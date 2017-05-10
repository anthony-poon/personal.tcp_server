package net.anthonypoon.tcp_server.message;

import com.google.gson.Gson;
import java.net.UnknownHostException;
import java.util.Date;

/**
 *
 * @author ypoon
 */
public class HandshakeMessage {
    private MessageFlag flag = MessageFlag.NULL_FLAG;
    private String destination;  
    private String payload;
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String getDestination() {
        return this.destination;
    }
    
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void setFlag(MessageFlag flag) {
        this.flag = flag;
    }
    
    public MessageFlag getFlag() {
        return this.flag;
    }
    
    public void addPayload(String payload) {
        this.payload = payload;
    }
    
    public String getPayload() {
        return payload;
    }
}
