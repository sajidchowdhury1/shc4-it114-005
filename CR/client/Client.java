package CR.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.logging.Logger;


import CR.common.Constants;
import CR.common.Payload;
import CR.common.PayloadType;
import CR.common.RoomResultPayload;

// shc4 11/29/23 it114-005
// import for array list
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public enum Client {
    INSTANCE;

    Socket server = null;
    ObjectOutputStream out = null;
    ObjectInputStream in = null;
    final String ipAddressPattern = "/connect\\s+(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}:\\d{3,5})";
    final String localhostPattern = "/connect\\s+(localhost:\\d{3,5})";
    boolean isRunning = false;
    private Thread inputThread;
    private Thread fromServerThread;
    //private String clientName = "";
    private User myUser = new User();
    private long myClientId = Constants.DEFAULT_CLIENT_ID;
    private static Logger logger = Logger.getLogger(Client.class.getName());

    private Hashtable<Long, User> userList = new Hashtable<Long, User>();
    // shc4 11/18/23 it114-005
    // commends to handle mute and unmute commends
    private final static String COMMAND = "/";
    private final static String MUTEUSER = "mute";
    private final static String UNMUTEUSER = "unmute";

    // shc4 11/29/23 it114-005
    // this is the mute list within clients
    protected List<String> muteList = new ArrayList<String>();

    private static IClientEvents events;

    public boolean isConnected() {
        if (server == null) {
            return false;
        }
        // https://stackoverflow.com/a/10241044
        // Note: these check the client's end of the socket connect; therefore they
        // don't really help determine
        // if the server had a problem
        return server.isConnected() && !server.isClosed() && !server.isInputShutdown() && !server.isOutputShutdown();

    }

    /**
     * Takes an ip address and a port to attempt a socket connection to a server.
     * 
     * @param address
     * @param port
     * @param username
     * @param callback (for triggering UI events)
     * @return true if connection was successful
     */
    public boolean connect(String address, int port, String username, IClientEvents callback) {
        // TODO validate
        //this.clientName = username;
        myUser.setClientName(username);
        Client.events = callback;
        try {
            server = new Socket(address, port);
            // channel to send to server
            out = new ObjectOutputStream(server.getOutputStream());
            // channel to listen to server
            in = new ObjectInputStream(server.getInputStream());
            logger.info("Client connected");
            listenForServerPayload();
            sendConnect();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isConnected();
    }


    public void sendListRooms(String query) throws IOException {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.GET_ROOMS);
        p.setMessage(query);
        out.writeObject(p);
    }

    public void sendJoinRoom(String roomName) throws IOException {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.JOIN_ROOM);
        p.setMessage(roomName);
        out.writeObject(p);
    }

    public void sendCreateRoom(String roomName) throws IOException {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.CREATE_ROOM);
        p.setMessage(roomName);
        out.writeObject(p);
    }

    protected void sendDisconnect() throws IOException {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.DISCONNECT);
        out.writeObject(p);
    }

    protected void sendConnect() throws IOException {
        Payload p = new Payload();
        p.setPayloadType(PayloadType.CONNECT);
        p.setClientName(myUser.getClientName());
        out.writeObject(p);
    }

    public void sendMessage(String message) throws IOException {
        // shc4 11/18/23 it114-005
        // this will check if its a commmend and if not it will do a normal send message
        if(processCommend(message)){
            return;
        }
        Payload p = new Payload();
        p.setPayloadType(PayloadType.MESSAGE);
        p.setMessage(message);
        p.setClientName(myUser.getClientName());
        out.writeObject(p);
    }

    // end send methods

    private void listenForServerPayload() {
        isRunning = true;
        fromServerThread = new Thread() {
            @Override
            public void run() {
                try {
                    Payload fromServer;

                    // while we're connected, listen for objects from server
                    while (isRunning && !server.isClosed() && !server.isInputShutdown()
                            && (fromServer = (Payload) in.readObject()) != null) {

                        logger.info("Debug Info: " + fromServer);
                        processPayload(fromServer);
                        // shc4 12/4/23 it114-005
                        updateStatus("mute");

                    }
                    logger.info("listenForServerPayload() loop exited");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    logger.info("Stopped listening to server input");
                    close();
                }
            }
        };
        fromServerThread.start();// start the thread
    }

    protected String getClientNameById(long id) {
        if (userList.containsKey(id)) {
            return userList.get(id).getClientName();
        }
        if (id == Constants.DEFAULT_CLIENT_ID) {
            return "[Server]";
        }
        return "unknown user";
    }

    // shc4 11/18/23 it114-005
    // process commend to use mute and unmute
    private boolean processCommend(String commend){
        boolean isCommend = false;
        
        if(commend.startsWith(COMMAND)){
            try{
                isCommend = true;
                String check = commend.substring(1).trim().split(" ")[0]; // mute or unmute commend
                String name = commend.substring(1).trim().split(" ")[1]; // name of the user
                if(name.equalsIgnoreCase(myUser.getClientName())){
                    //System.out.println("You cannot mute/unmute youself");
                    events.onMessageReceive(-1,"<b>You cannot mute/unmute youself</b>");
                    isCommend = false;
                    return isCommend;
                }
                switch(check){
                    // mute
                    case MUTEUSER:
                        this.muteUser(name);
                        break;
                    // unmute
                    case UNMUTEUSER:
                        this.unmuteUser(name);
                        break;
                    default:
                        isCommend = false;
                        break;
                }
            }catch(Exception e){
                //System.out.print("Invalid format for commend");
                //events.onMessageReceive(-1,"<b>Invalid format for commend</b>");
                isCommend = false;
            }
        }
        return isCommend;
    }

    // shc4 11/18/23 it114-005
    // payload method to handle mute
    public void muteUser(String name) throws IOException{
        Payload p = new Payload();
        p.setPayloadType(PayloadType.MUTE);
        p.setClientName(name);
        out.writeObject(p);
    }
    // payload method to handle unmute
    public void unmuteUser(String name) throws IOException{
        Payload p = new Payload();
        p.setPayloadType(PayloadType.UNMUTE);
        p.setClientName(name);
        out.writeObject(p);
    }

    // shc4 12/4/23 it114-005
    private void updateStatus(String status){
        // link: https://www.geeksforgeeks.org/how-to-iterate-through-hashtable-in-java/ (iterating hastable)
        // link: https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html
        // link: https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/util/Set.html
        // link: https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
        Set<Long> ListId = userList.keySet();
        Iterator<Long> Users = ListId.iterator(); 
        while(Users.hasNext()){
            Long value = Users.next();
            User otherUser = userList.get(value);
            if(status.equals("mute") && muteList.indexOf(otherUser.getClientName()) > -1){
                events.updateMuteStatus(status, otherUser.getClientId());
            }
            if(status.equals("unmute") && !muteList.contains(otherUser.getClientName())){
                events.updateMuteStatus(status, otherUser.getClientId());
            }
        }
    }

    /**
     * Processes incoming payloads from ServerThread
     * 
     * @param p
     */
    private void processPayload(Payload p) {
        switch (p.getPayloadType()) {
            case CONNECT:
                if (!userList.containsKey(p.getClientId())) {
                    User cp = new User();
                    cp.setClientName(p.getClientName());
                    cp.setClientId(p.getClientId());
                    userList.put(p.getClientId(), cp);
                }
                System.out.println(String.format("*%s %s*",
                        p.getClientName(),
                        p.getMessage()));
                events.onClientConnect(p.getClientId(), p.getClientName(), p.getMessage());
                break;
            case DISCONNECT:
                if (userList.containsKey(p.getClientId())) {
                    userList.remove(p.getClientId());
                }
                if (p.getClientId() == myClientId) {
                    myClientId = Constants.DEFAULT_CLIENT_ID;
                }
                System.out.println(String.format("*%s %s*",
                        p.getClientName(),
                        p.getMessage()));
                events.onClientDisconnect(p.getClientId(), p.getClientName(), p.getMessage());
                break;
            case SYNC_CLIENT:
                if (!userList.containsKey(p.getClientId())) {
                    User cp = new User();
                    cp.setClientName(p.getClientName());
                    cp.setClientId(p.getClientId());
                    userList.put(p.getClientId(), cp);
                }
                events.onSyncClient(p.getClientId(), p.getClientName());
                break;
            case MESSAGE:
                System.out.println(String.format("%s: %s",
                        getClientNameById(p.getClientId()),
                        p.getMessage()));
                events.onMessageReceive(p.getClientId(), p.getMessage());
                // shc4 12/4/23 it114-005
                events.updateMessageStatus(p.getClientId());
                break;
            case CLIENT_ID:
                if (myClientId == Constants.DEFAULT_CLIENT_ID) {
                    myClientId = p.getClientId();
                    myUser.setClientId(myClientId);
                    userList.put(myClientId, myUser);
                } else {
                    logger.warning("Receiving client id despite already being set");
                }
                events.onReceiveClientId(p.getClientId());
                break;
            case GET_ROOMS:
                RoomResultPayload rp = (RoomResultPayload) p;
                System.out.println("Received Room List:");
                if (rp.getMessage() != null) {
                    System.out.println(rp.getMessage());
                } else {
                    for (int i = 0, l = rp.getRooms().length; i < l; i++) {
                        System.out.println(String.format("%s) %s", (i + 1), rp.getRooms()[i]));
                    }
                }
                events.onReceiveRoomList(rp.getRooms(), rp.getMessage());
                break;
            case RESET_USER_LIST:
                userList.clear();
                events.onResetUserList();
                break;
            // shc4 11/18/23 it114-005
            // this is to handle mute message and unmute message
            case MUTE:
                events.onMessageReceive(-1, String.format("<b><font color=\"red\">%s was muted</font></b>",p.getClientName()));
                // shc4 12/1/23 it114-005
                // this is going to update the status every time mute is done
                updateStatus("mute");
                break;
            case UNMUTE:
                events.onMessageReceive(-1, String.format("<b><font color=\"green\">%s was unmuted</font></b>",p.getClientName()));
                // this is going to be update the statys every time unmute is done
                updateStatus("unmute");
                break;
            // shc4 11/29/23
            // this handles the must list that comes in
            case MUTE_LIST:
                // link: https://www.geeksforgeeks.org/list-clear-method-in-java-with-examples/
                muteList.clear();
                String[] names = p.getMessage().split(",");
                for(String i: names){
                    if(i.equals(" ")){
                        continue;
                    }
                    muteList.add(i.trim());
                }
                break;
            default:
                logger.warning(String.format("Unhandled Payload type: %s", p.getPayloadType()));
                break;

        }
    }

    private void close() {
        myClientId = Constants.DEFAULT_CLIENT_ID;
        userList.clear();
        try {
            inputThread.interrupt();
        } catch (Exception e) {
            System.out.println("Error interrupting input");
            e.printStackTrace();
        }
        try {
            fromServerThread.interrupt();
        } catch (Exception e) {
            System.out.println("Error interrupting listener");
            e.printStackTrace();
        }
        try {
            System.out.println("Closing output stream");
            out.close();
        } catch (NullPointerException ne) {
            System.out.println("Server was never opened so this exception is ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Closing input stream");
            in.close();
        } catch (NullPointerException ne) {
            System.out.println("Server was never opened so this exception is ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Closing connection");
            server.close();
            System.out.println("Closed socket");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException ne) {
            System.out.println("Server was never opened so this exception is ok");
        }
    }
}