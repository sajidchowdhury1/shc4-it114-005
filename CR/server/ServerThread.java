package CR.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import CR.common.Constants;
import CR.common.Payload;
import CR.common.PayloadType;
import CR.common.RoomResultPayload;

// shc4 11/17/23 it114-005
import java.util.ArrayList;
import java.util.List;

/**
 * A server-side representation of a single client
 */
public class ServerThread extends Thread {
    private Socket client;
    private String clientName;
    private boolean isRunning = false;
    private ObjectOutputStream out;// exposed here for send()
    // private Server server;// ref to our server so we can call methods on it
    // more easily
    private Room currentRoom;
    private static Logger logger = Logger.getLogger(ServerThread.class.getName());
    private long myClientId;

    // shc4 11/17/23 it114-005
    // mute list
    private List<String> muteList = new ArrayList<String>();

    public void setClientId(long id) {
        myClientId = id;
    }

    public long getClientId() {
        return myClientId;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public ServerThread(Socket myClient, Room room) {
        logger.info("ServerThread created");
        // get communication channels to single client
        this.client = myClient;
        this.currentRoom = room;

    }

    protected void setClientName(String name) {
        if (name == null || name.isBlank()) {
            logger.warning("Invalid name being set");
            return;
        }
        clientName = name;
    }

    public String getClientName() {
        return clientName;
    }

    protected synchronized Room getCurrentRoom() {
        return currentRoom;
    }

    protected synchronized void setCurrentRoom(Room room) {
        if (room != null) {
            currentRoom = room;
        } else {
            logger.info("Passed in room was null, this shouldn't happen");
        }
    }

    public void disconnect() {
        sendConnectionStatus(myClientId, getClientName(), false);
        logger.info("Thread being disconnected by server");
        isRunning = false;
        cleanup();
    }

    // send methods
    // shc4 11/11/23 it114-005
    // These payloads were given with the milestone2 prep
    // sendReadyStatus would send a payload showing which client is ready and active 
    public boolean sendReadyStatus(long clientId) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.READY);
        p.setClientId(clientId);
        return send(p);
    }

    // shc4 11/11/23 it114-005
    // This one payload will be the name of the room
    public boolean sendRoomName(String name) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.JOIN_ROOM);
        p.setMessage(name);
        return send(p);
    }

    public boolean sendRoomsList(String[] rooms, String message) {
        RoomResultPayload payload = new RoomResultPayload();
        payload.setRooms(rooms);
        if (message != null) {
            payload.setMessage(message);
        }
        return send(payload);
    }

    // shc4 11/11/23 it114-005
    // This will will send the client Id and the client name
    public boolean sendExistingClient(long clientId, String clientName) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.SYNC_CLIENT);
        p.setClientId(clientId);
        p.setClientName(clientName);
        return send(p);
    }

    // shc4 11/11/23 it114-005
    // This will send and handle data of the users list and have only people that are active
    public boolean sendResetUserList() {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.RESET_USER_LIST);
        return send(p);
    }

    // shc4 11/11/23 it114-005
    // This is to send and handle the ID of the client
    public boolean sendClientId(long id) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.CLIENT_ID);
        p.setClientId(id);
        return send(p);
    }

    // shc4 11/11/23 it114-005
    // this handles th client who is sending a message and also the message that is being sent
    public boolean sendMessage(long clientId, String message) {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.MESSAGE);
        p.setClientId(clientId);
        p.setMessage(message);
        return send(p);
    }

    // shc4 11/11/23 it114-005
    // These payloads will handle who is connected and disconnected in a room
    public boolean sendConnectionStatus(long clientId, String who, boolean isConnected) {
        Payload p = new Payload();
        p.setPayloadType(isConnected ? PayloadType.CONNECT : PayloadType.DISCONNECT);
        p.setClientId(clientId);
        p.setClientName(who);
        p.setMessage(String.format("%s the room %s", (isConnected ? "Joined" : "Left"), currentRoom.getName()));
        return send(p);
    }

    private boolean send(Payload payload) {
        try {
            logger.log(Level.FINE, "Outgoing payload: " + payload);
            out.writeObject(payload);
            logger.log(Level.INFO, "Sent payload: " + payload);
            return true;
        } catch (IOException e) {
            logger.info("Error sending message to client (most likely disconnected)");
            // uncomment this to inspect the stack trace
            // e.printStackTrace();
            cleanup();
            return false;
        } catch (NullPointerException ne) {
            logger.info("Message was attempted to be sent before outbound stream was opened: " + payload);
            // uncomment this to inspect the stack trace
            // e.printStackTrace();
            return true;// true since it's likely pending being opened
        }
    }

    // end send methods
    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());) {
            this.out = out;
            isRunning = true;
            Payload fromClient;
            while (isRunning && // flag to let us easily control the loop
                    (fromClient = (Payload) in.readObject()) != null // reads an object from inputStream (null would
                                                                     // likely mean a disconnect)
            ) {

                logger.info("Received from client: " + fromClient);
                processPayload(fromClient);

            } // close while loop
        } catch (Exception e) {
            // happens when client disconnects
            e.printStackTrace();
            logger.info("Client disconnected");
        } finally {
            isRunning = false;
            logger.info("Exited thread loop. Cleaning up connection");
            cleanup();
        }
    }

    // shc4 11/17/23 it114-005
    // this payload will handle the mute people
    public boolean sendMuteUser(String name){
        Payload p = new Payload();
        p.setPayloadType(PayloadType.MUTE);
        p.setClientName(name);
        return send(p);
    }

    public boolean sendUnmuteUser(String name){
        Payload p = new Payload();
        p.setPayloadType(PayloadType.UNMUTE);
        p.setClientName(name);
        return send(p);
    }

    // shc4 11/18/23 it114-005
    // checks if a person is muted
    public boolean isMuted(String name){
        for(String i: muteList){
            if(i.equals(name)){
                return true;
            }
        }
        return false;
    }

    // shc4 11/11/23 it114-005
    // this works with the different types of payload depending on what the user does
    // so it has connect, disconnect, and other payloads the is helpful for the user
    void processPayload(Payload p) {
        switch (p.getPayloadType()) {
            case CONNECT:
                setClientName(p.getClientName());
                break;
            case DISCONNECT:
                Room.disconnectClient(this, getCurrentRoom());
                break;
            case MESSAGE:
                if (currentRoom != null) {
                    currentRoom.sendMessage(this, p.getMessage());
                } else {
                    // TODO migrate to lobby
                    logger.log(Level.INFO, "Migrating to lobby on message with null room");
                    Room.joinRoom(Constants.LOBBY, this);
                }
                break;
            case GET_ROOMS:
                Room.getRooms(p.getMessage().trim(), this);
                break;
            case CREATE_ROOM:
                Room.createRoom(p.getMessage().trim(), this);
                break;
            case JOIN_ROOM:
                Room.joinRoom(p.getMessage().trim(), this);
                break;
            // shc4 11/18/23 it114-005
            // process payloads to handle mute list
            // Link: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
            case MUTE:
                if(!muteList.contains(p.getClientName())){
                    muteList.add(p.getClientName());
                    sendMuteUser(p.getClientName());
                }
                break;
            case UNMUTE:
                muteList.remove(p.getClientName());
                sendUnmuteUser(p.getClientName());
                break;
            //case READY:
                // ((GameRoom) currentRoom).setReady(myClientId);
                //break;
            default:
                break;

        }

    }

    private void cleanup() {
        logger.info("Thread cleanup() start");
        try {
            client.close();
        } catch (IOException e) {
            logger.info("Client already closed");
        }
        logger.info("Thread cleanup() complete");
    }
}
