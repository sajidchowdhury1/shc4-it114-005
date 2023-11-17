package CR.common;

public enum PayloadType {
    // shc4 11/11/23 it114-005
    // These are the payloads that come with the milestone 2 prep
    CONNECT, DISCONNECT, MESSAGE, CLIENT_ID, RESET_USER_LIST,
    SYNC_CLIENT, CREATE_ROOM, JOIN_ROOM, GET_ROOMS,
    READY, MUTE, PRIVATE //Mute is a new payload 
}
