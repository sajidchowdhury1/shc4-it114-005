package CR.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Room implements AutoCloseable{
	protected static Server server;// used to refer to accessible server functions
	private String name;
	private List<ServerThread> clients = new ArrayList<ServerThread>();
	private boolean isRunning = false;
	// Commands
	private final static String COMMAND_TRIGGER = "/";
	private final static String CREATE_ROOM = "createroom";
	private final static String JOIN_ROOM = "joinroom";
	private final static String DISCONNECT = "disconnect";
	private final static String LOGOUT = "logout";
	private final static String LOGOFF = "logoff";

	public Room(String name) {
		this.name = name;
		isRunning = true;
	}

	private void info(String message) {
		System.out.println(String.format("Room[%s]: %s", name, message));
	}

	public String getName() {
		return name;
	}

	protected synchronized void addClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		client.setCurrentRoom(this);
		if (clients.indexOf(client) > -1) {
			info("Attempting to add a client that already exists");
		} else {
			clients.add(client);
			new Thread() {
				@Override
				public void run() {
					// slight delay to let potentially new client to finish
					// binding input/output streams
					// comment out the Thread.sleep to see what happens
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//sendMessage(client, "joined the room " + getName());
					sendConnectionStatus(client, true);
				}
			}.start();

		}
	}

	protected synchronized void removeClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		clients.remove(client);
		// we don't need to broadcast it to the server
		// only to our own Room
		if (clients.size() > 0) {
			//sendMessage(client, "left the room");
			sendConnectionStatus(client, false);
		}
		checkClients();
	}

	/***
	 * Checks the number of clients.
	 * If zero, begins the cleanup process to dispose of the room
	 */
	private void checkClients() {
		// Cleanup if room is empty and not lobby
		if (!name.equalsIgnoreCase("lobby") && clients.size() == 0) {
			close();
		}
	}

	/***
	 * Helper function to process messages to trigger different functionality.
	 * 
	 * @param message The original message being sent
	 * @param client  The sender of the message (since they'll be the ones
	 *                triggering the actions)
	 */
	private boolean processCommands(String message, ServerThread client) {
		boolean wasCommand = false;
		try {
			if (message.startsWith(COMMAND_TRIGGER)) {
				String[] comm = message.split(COMMAND_TRIGGER);
				String part1 = comm[1];
				String[] comm2 = part1.split(" ");
				String command = comm2[0];
				String roomName;
				wasCommand = true;
				switch (command) {
					case CREATE_ROOM:
						roomName = comm2[1];
						Room.createRoom(roomName, client);
						break;
					case JOIN_ROOM:
						roomName = comm2[1];
						Room.joinRoom(roomName, client);
						break;
					case DISCONNECT:
					case LOGOUT:
					case LOGOFF:
						Room.disconnectClient(client, this);
						break;
					default:
						wasCommand = false;
						break;
				}
				// shc4 10/27/23 IT114-005
				// coin flip
				if(message.trim().startsWith("/flip")){
					int coin = (int) (Math.random()*2); 
						if(coin == 0){
							client.sendMessage(client.getClientName(),"Did a coin flip and landed on Heads");
						}
						else if(coin == 1){
							client.sendMessage(client.getClientName(),"Did a coin flip and landed on Tails");
						}
						return true;
				}
				// roll multiple dice with multiple sides (format 2)
				// Link: https://www.w3schools.com/java/ref_string_contains.asp used to figure out .contains method
				else if(message.trim().startsWith("/roll")){
					int total = 0;
					try{
						if(message.trim().split(" ")[1].contains("d")){
							String numberOfDice = message.split(" ")[1].split("d")[0];
							String sidesOfDice = message.split(" ")[1].split("d")[1];

							for(int i = 0; i < Integer.parseInt(numberOfDice); i++){
								int rollDice = (int) (Math.random()*Integer.parseInt(sidesOfDice))+1;
								total += rollDice;
							}
							client.sendMessage(client.getClientName(), String.format("Did a roll of %sd%s and got a total roll of %s", numberOfDice, sidesOfDice, total));
						} 
						else{
							int value = Integer.parseInt(message.trim().split(" ")[1]);
							int singleDiceRoll = (int) (Math.random()*value)+1;
							client.sendMessage(client.getClientName(), String.format("The dice rolls from a range of 1-%s and the result is %s", value, singleDiceRoll));
						}
						return true;
					}catch(Exception e){
						client.sendMessage(null,"invalid input");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wasCommand;
	}

	// Command helper methods
	protected static void createRoom(String roomName, ServerThread client) {
		if (server.createNewRoom(roomName)) {
			//server.joinRoom(roomName, client);
			Room.joinRoom(roomName, client);
		} else {
			client.sendMessage("Server", String.format("Room %s already exists", roomName));
		}
	}

	protected static void joinRoom(String roomName, ServerThread client) {
		if (!server.joinRoom(roomName, client)) {
			client.sendMessage("Server", String.format("Room %s doesn't exist", roomName));
		}
	}

	protected static void disconnectClient(ServerThread client, Room room) {
		client.setCurrentRoom(null);
		client.disconnect();
		room.removeClient(client);
	}
	// end command helper methods

	/***
	 * Takes a sender and a message and broadcasts the message to all clients in
	 * this room. Client is mostly passed for command purposes but we can also use
	 * it to extract other client info.
	 * 
	 * @param sender  The client sending the message
	 * @param message The message to broadcast inside the room
	 */
	protected synchronized void sendMessage(ServerThread sender, String message) {
		if (!isRunning) {
			return;
		}
		info("Sending message to " + clients.size() + " clients");
		if (sender != null && processCommands(message, sender)) {
			// it was a command, don't broadcast
			return;
		}
		
		String from = (sender == null ? "Room" : sender.getClientName());
		Iterator<ServerThread> iter = clients.iterator();
		// shc4 10/20/23 it114-005
		// formatting
		// I had support from Danny
		message = convertMessage(message);
		
		while (iter.hasNext()) {
			ServerThread client = iter.next();
			boolean messageSent = client.sendMessage(from, message);
			if (!messageSent) {
				handleDisconnect(iter, client);
			}
		}
	}
	// shc4 11/5/23 it114-005
	// method for formatting all
	private String convertMessage(String message){
		// bold formatting '*'
		if(message.contains("*")){
			String[] message2 = message.split("");
			message = "";
			int count = 0;
			int check = 0;
			int trackIndex = 0;
			for(int i = 0; i < message2.length; i++){
				if(message2[i].equals("\\")){
					// this allows the user to keep their symbols if they wish to do so
					message2[i] = "";
					i++;
					continue;
				}
				if (message2[i].equals("*")){
					count++;
					check++;
					if(count == 1){
						trackIndex = i;
						message2[i] = "<b>";
					}
					
					if (count == 2){
						message2[i] = "</b>";
						count = 0;
					}
				}
			}
			if(check % 2 == 1){
				message2[trackIndex] = "*";
			}
			for(String i: message2){
				message += i;
			}
			return message;
		}
		// formatting for italics '-'
		if(message.contains("-")){
			String[] message2 = message.split("");
			message = "";
			int count = 0;
			int check = 0;
			int trackIndex = 0;
			for(int i = 0; i < message2.length; i++){
				if(message2[i].equals("\\")){
					// this allows the user to keep their symbols if they wish to do so
					message2[i] = "";
					i++;
					continue;
				}
				if (message2[i].equals("-")){
					count++;
					check++;
					if(count == 1){
						trackIndex = i;
						message2[i] = "<i>";
					}
					
					if (count == 2){
						message2[i] = "</i>";
						count = 0;
					}
				}
			}
			if(check % 2 == 1){
				message2[trackIndex] = "-";
			}
			for(String i: message2){
				message += i;
			}
			return message;
		}
		// formatting for underline '_'
		if(message.contains("_")){
			String[] message2 = message.split("");
			message = "";
			int count = 0;
			int check = 0;
			int trackIndex = 0;
			for(int i = 0; i < message2.length; i++){
				if(message2[i].equals("\\")){
					// this allows the user to keep their symbols if they wish to do so
					message2[i] = "";
					i++;
					continue;
				}
				if (message2[i].equals("_")){
					count++;
					check++;
					if(count == 1){
						trackIndex = i;
						message2[i] = "<u>";
					}
					
					if (count == 2){
						message2[i] = "</u>";
						count = 0;
					}
				}
			}
			if(check % 2 == 1){
				message2[trackIndex] = "_";
			}
			for(String i: message2){
				message += i;
			}
			return message;
		}
		// color support RGB
		if(message.contains("&")){
			String[] message2 = message.split("");
			message = "";
			int count = 0;
			int check = 0;
			int trackIndex = 0;
			for(int i = 0; i < message2.length; i++){
				if(message2[i].equals("&")){
					message2[i] = "";
					if(message2[i+1].equals("r")){
						count++;
						check++;
						if(count == 1){
							trackIndex = i;
							message2[i+1] = "<font color=\"red\">";
						}
						
						if (count == 2){
							message2[i] = "</font>";
							count = 0;
						}
					}
					if(message2[i+1].equals("g")){
						count++;
						check++;
						if(count == 1){
							trackIndex = i;
							message2[i] = "<font color=\"green\">";
						}
						
						if (count == 2){
							message2[i] = "</font>";
							count = 0;
						}
					}
					if(message2[i+1].equals("b")){
						count++;
						check++;
						if(count == 1){
							trackIndex = i;
							message2[i] = "<font color=\"blue\">";
						}
						
						if (count == 2){
							message2[i] = "</font>";
							count = 0;
						}

					}
				}
			}
			for(String i: message2){
				message += i;
			}
			return message;

		}

		return message;
	}

	protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected){
		Iterator<ServerThread> iter = clients.iterator();
		while (iter.hasNext()) {
			ServerThread client = iter.next();
			boolean messageSent = client.sendConnectionStatus(sender.getClientName(), isConnected);
			if (!messageSent) {
				handleDisconnect(iter, client);
			}
		}
	}
	private void handleDisconnect(Iterator<ServerThread> iter, ServerThread client){
		iter.remove();
		info("Removed client " + client.getClientName());
		checkClients();
		sendMessage(null, client.getClientName() + " disconnected");
	}
	public void close() {
		server.removeRoom(this);
		server = null;
		isRunning = false;
		clients = null;
	}
}