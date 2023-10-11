package Part3HW.Part3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Server {
    // shc4 10/9/23 it114-005
    // variable to hold data for the number guesser
    private int randomNum = -1;
    // variable to set coinFace to heads or tails
    private String coinFace = "";

    int port = 3001;
    // connected clients
    private List<ServerThread> clients = new ArrayList<ServerThread>();

    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            System.out.println("Server is listening on port " + port);
            do {
                System.out.println("waiting for next client");
                if (incoming_client != null) {
                    System.out.println("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, this);
                    
                    clients.add(sClient);
                    sClient.start();
                    incoming_client = null;
                    
                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            System.err.println("Error accepting connection");
            e.printStackTrace();
        } finally {
            System.out.println("closing server socket");
        }
    }
    protected synchronized void disconnect(ServerThread client) {
		long id = client.getId();
        client.disconnect();
		broadcast("Disconnected", id);
	}
    
    protected synchronized void broadcast(String message, long id) {
        if(processCommand(message, id)){

            return;
        }
        // let's temporarily use the thread id as the client identifier to
        // show in all client's chat. This isn't good practice since it's subject to
        // change as clients connect/disconnect
        message = String.format("User[%d]: %s", id, message);
        // end temp identifier
        
        // loop over clients and send out the message
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            boolean wasSuccessful = client.send(message);
            if (!wasSuccessful) {
                System.out.println(String.format("Removing disconnected client[%s] from list", client.getId()));
                it.remove();
                broadcast("Disconnected", id);
            }
        }
    }

    private boolean processCommand(String message, long clientId){
        System.out.println("Checking command: " + message);
        if(message.equalsIgnoreCase("disconnect")){
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()) {
                ServerThread client = it.next();
                if(client.getId() == clientId){
                    it.remove();
                    disconnect(client);
                    
                    break;
                }
            }
            return true;
        }
        // shc4 10/9/23 it114-005
        // Got help from Professor Toguel during office hours
        // Number Guesser
        // The takes three else if to run, One command to start the game and random value
        // The second else if exits the game and sets randomNum to a different value
        // The third else if work when they use the word guess first and when randomNum is not set to -1
        // There are if and else if to check the it any of the clients got it right or wrong
        else if (message.trim().equalsIgnoreCase("start game")){
            randomNum = (int) (Math.random()*10)+1;
            broadcast("Number Guesser: (Select and number between 1-10) ", clientId);
            return true;
        }
        else if (message.trim().equalsIgnoreCase("exit game")){
            broadcast("Game stopped", clientId);
            randomNum = -1;
            return true;
        }
        else if (message.startsWith("guess") && randomNum > -1){
            try{
                int x = Integer.parseInt(message.split(" ")[1]);
                if(x == randomNum){
                    broadcast(String.format("The correct number was %s and the user who guessed it was %s", randomNum, clientId), clientId);
                    randomNum = (int) (Math.random()*10)+1;
                    broadcast("Number Guesser: \n(Select and number between 1-10) ", clientId);
                }
                else if(x < randomNum || x > randomNum){
                    broadcast(String.format("Incorrect Guess: %s from User %s", x, clientId), clientId);
                }
            }catch(NumberFormatException e){
                broadcast("Invalid input, type a number", clientId);
            }catch(ArrayIndexOutOfBoundsException e){
                broadcast("Invalid input, type a number", clientId);
            }
            return true;
        } // end of number guesser here
        
        // shc4 10/9/23 it114-005
        // Coin toss starts here
        // Checks for the word flip
        // Once it runs val chooses a number between 0 and 1
        // Once thats choosen, then the other if conditions will determine heads or tails
        // Then it broadcasts the results of who did coin flip
        else if (message.trim().equalsIgnoreCase("flip")){
            // val is only used in the iteration flip was commended
            int val = (int)(Math.random()*2);
            if (val == 0){
                // heads
                coinFace = "Heads";
            }
            else if (val == 1){
                // tails
                coinFace = "Tails";
            }
            // tells everyone what coin the user landed on
            broadcast(String.format("Coin flip was done by %s and landed on %s", clientId, coinFace), clientId);

            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Starting Server");
        Server server = new Server();
        int port = 3000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        server.start(port);
        System.out.println("Server Stopped");
    }
}