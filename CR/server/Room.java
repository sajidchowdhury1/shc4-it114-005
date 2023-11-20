package CR.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import CR.common.Constants;

public class Room implements AutoCloseable {
    // server is a singleton now so we don't need this
    // protected static Server server;// used to refer to accessible server
    // functions
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
    // shc4 11/8/23 it114-005
    private final static String FLIP = "flip";
    private final static String ROLL = "roll";
    private static Logger logger = Logger.getLogger(Room.class.getName());

    public Room(String name) {
        this.name = name;
        isRunning = true;
    }

    public String getName() {
        return name;
    }

    public boolean isRunning() {
        return isRunning;
    }

    protected synchronized void addClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        client.setCurrentRoom(this);
        if (clients.indexOf(client) > -1) {
            logger.warning("Attempting to add client that already exists in room");
        } else {
            clients.add(client);
            client.sendResetUserList();
            syncCurrentUsers(client);
            sendConnectionStatus(client, true);
        }
    }

    protected synchronized void removeClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        // attempt to remove client from room
        try {
            clients.remove(client);
        } catch (Exception e) {
            logger.severe(String.format("Error removing client from room %s", e.getMessage()));
            e.printStackTrace();
        }
        // if there are still clients tell them this person left
        if (clients.size() > 0) {
            sendConnectionStatus(client, false);
        }
        checkClients();
    }

    private void syncCurrentUsers(ServerThread client) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread existingClient = iter.next();
            if (existingClient.getClientId() == client.getClientId()) {
                continue;// don't sync ourselves
            }
            boolean messageSent = client.sendExistingClient(existingClient.getClientId(),
                    existingClient.getClientName());
            if (!messageSent) {
                handleDisconnect(iter, existingClient);
                break;// since it's only 1 client receiving all the data, break if any 1 send fails
            }
        }
    }

    /***
     * Checks the number of clients.
     * If zero, begins the cleanup process to dispose of the room
     */
    private void checkClients() {
        // Cleanup if room is empty and not lobby
        if (!name.equalsIgnoreCase(Constants.LOBBY) && (clients == null || clients.size() == 0)) {
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
    @Deprecated // not used in my project as of this lesson, keeping it here in case things
                // change
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
                    case FLIP:
                    // shc4 11/8/23 it114-005
                    // flip
                    // had support from Danny, Daniel, and Yaneli
                        System.out.println("Test 1");
                        int coin = (int) (Math.random()*2); 
                        if(coin == 0){
                            // shc4 11/16/23 it114-005
                            // has been modified for formatting on ui interface so flip can look different
                            sendMessage(null,String.format("<b>%s did a coin <i><font color=\"blue\">flip</font><i> and landed on <i><font color=\"green\">Heads</font></i></b>", client.getClientName()));
                        }
                        else if(coin == 1){
                            sendMessage(null,String.format("<b>%s did a coin <i><font color=\"blue\">flip</font><i> and landed on <i><font color=\"green\">Tails</font></i></b>", client.getClientName()));
                        }
                        break;
                    case ROLL:
                    System.out.println("Test 2");
                        int total = 0;
                        try{
                            if(message.trim().split(" ")[1].contains("d")){
                                String numberOfDice = message.split(" ")[1].split("d")[0];
                                String sidesOfDice = message.split(" ")[1].split("d")[1];

                                for(int i = 0; i < Integer.parseInt(numberOfDice); i++){
                                    int rollDice = (int) (Math.random()*Integer.parseInt(sidesOfDice))+1;
                                    total += rollDice;
                                }
                                sendMessage(null, String.format("<b>%s did a <i><font color=\"red\">roll</font></i> of <u>%sd%s</u> and got a total roll of <font color=\"red\">%s</font></b>", client.getClientName(), numberOfDice, sidesOfDice, total));
                            } 
                            else{
                                int value = Integer.parseInt(message.trim().split(" ")[1]);
                                int singleDiceRoll = (int) (Math.random()*value)+1;
                                sendMessage(null, String.format("<b>%s did a <i><font color=\"red\">roll</font></i> with a range of <u>1-%s</u> and the result is <font color=\"red\">%s</font></b>", client.getClientName(),value, singleDiceRoll));
                            }
                            return true;
                        }catch(Exception e){
                            sendMessage(null,"<b><font color=\"red\">invalid input</font></b>");
                        }
                        break;
                    default:
                        wasCommand = false;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wasCommand;
    }

    // Command helper methods
    protected static void getRooms(String query, ServerThread client) {
        String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
        client.sendRoomsList(rooms,
                (rooms != null && rooms.length == 0) ? "No rooms found containing your query string" : null);
    }

    protected static void createRoom(String roomName, ServerThread client) {
        if (Server.INSTANCE.createNewRoom(roomName)) {
            Room.joinRoom(roomName, client);
        } else {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
        }
    }

    /**
     * Will cause the client to leave the current room and be moved to the new room
     * if applicable
     * 
     * @param roomName
     * @param client
     */
    protected static void joinRoom(String roomName, ServerThread client) {
        if (!Server.INSTANCE.joinRoom(roomName, client)) {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
        }
    }

    protected static void disconnectClient(ServerThread client, Room room) {
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
        logger.info(String.format("Sending message to %s clients", clients.size()));
        if (sender != null && processCommands(message, sender)) {
            // it was a command, don't broadcast
            return;
        }
        long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
        Iterator<ServerThread> iter = clients.iterator();
        // shc4 11/8/23 it114-005
		// formatting
		// I had support from Danny
		message = convertMessageBold(message); // use *
        message = ConvertMessageItalics(message); // use -
        message = ConvertMessageUnderline(message); // use _
        message = ConvertMessageRed(message); // use &
        message = ConvertMessageGreen(message); // use %
        message = ConvertMessageBlue(message); // use #
        

        // shc4 11/17/23 it114-005
        // private message
        if(sender != null && message.trim().startsWith("@")){
            try{
                String[] message2 = message.split(" ");
                String userName = message2[0].substring(1).split(":")[0];
                Long userID = Long.parseLong((message2[0].substring(1).split(":")[1]));
                if(userName.length() == 0) {
                    throw new Exception("Message");
                }
                sender.sendMessage(sender.getClientId(),String.format("<font color=#8B4000>Private Message: %s</font>", message));
                for(ServerThread i: clients){
                    if(i.isMuted(sender.getClientName())){
                        sender.sendMessage(sender.getClientId(), "<b><font color=\"red\">Message was muted</font></b>");
                        continue;
                    }
                    if(i.getClientName().equals(userName) && i.getClientId() == userID){
                        i.sendMessage(sender.getClientId(), String.format("<font color=#006400>Private Message: %s</font>", message));
                    }
                    else{
                        sender.sendMessage(-1, String.format("<b>Username or ID did not match</b>"));
                        throw new Exception();
                    }
                }
            }catch(Exception e){
                sender.sendMessage(-1, String.format("<b>Type <font color=#800080>@Username:ID (Message)</font> to properly send the message</b>"));
            }
            return;
        }
        
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            // shc4 11/17/23 it114-005
            if(sender != null && client.isMuted(sender.getClientName())){
                System.out.println("Yes, sender was muted");
                continue;
            }
            boolean messageSent = client.sendMessage(from, message);
            if (!messageSent) {
                handleDisconnect(iter, client);
            }
        }
    }

    // shc4 11/8/23 it114-005
	// method for formatting for bold
	// Had support from Danny
    private String convertMessageBold(String message){
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
		return message;
	}

    // shc4 11/12/23 it114-005
	// method for formatting for Italics
    private String ConvertMessageItalics(String message){
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
        return message;
    }
    // shc4 11/12/23 it114-005
	// method for formatting for underline
    private String ConvertMessageUnderline(String message){
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
        return message;
    }

    // shc4 11/12/23 it114-005
	// method for formatting to the color red
    // color support RGB
	// Link: https://www.freecodecamp.org/news/how-to-change-text-color-in-html/
    private String ConvertMessageRed(String message){
        if(message.contains("&")){
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
				if (message2[i].equals("&")){
					count++;
					check++;
					if(count == 1){
						trackIndex = i;
						message2[i] = "<font color=\"red\">";
					}
					
					if (count == 2){
						message2[i] = "</font>";
						count = 0;
					}
				}
			}
			if(check % 2 == 1){
				message2[trackIndex] = "&";
			}
			for(String i: message2){
				message += i;
			}
			return message;
		}
		return message;
    }
    // shc4 11/12/23 it114-005
	// method for formatting to the color green
    // color support RGB
    private String ConvertMessageGreen(String message){
        if(message.contains("%")){
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
				if (message2[i].equals("%")){
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
			}
			if(check % 2 == 1){
				message2[trackIndex] = "%";
			}
			for(String i: message2){
				message += i;
			}
			return message;
		}
		return message;
    }
    // shc4 11/12/23 it114-005
	// method for formatting to the color blue
    // color support RGB
    private String ConvertMessageBlue(String message){
        if(message.contains("#")){
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
				if (message2[i].equals("#")){
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
			if(check % 2 == 1){
				message2[trackIndex] = "#";
			}
			for(String i: message2){
				message += i;
			}
			return message;
		}
		return message;
    }

    protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread receivingClient = iter.next();
            boolean messageSent = receivingClient.sendConnectionStatus(
                    sender.getClientId(),
                    sender.getClientName(),
                    isConnected);
            if (!messageSent) {
                handleDisconnect(iter, receivingClient);
            }
        }
    }

    private void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
        iter.remove();
        logger.info(String.format("Removed client %s", client.getClientName()));
        sendMessage(null, client.getClientName() + " disconnected");
        checkClients();
    }

    public void close() {
        Server.INSTANCE.removeRoom(this);
        isRunning = false;
        clients.clear();
    }
}