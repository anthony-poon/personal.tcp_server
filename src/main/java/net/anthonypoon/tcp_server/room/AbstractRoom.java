/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.tcp_server.room;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.anthonypoon.tcp_server.message.HandshakeMessage;
import net.anthonypoon.tcp_server.message.MessageFlag;

/**
 *
 * @author ypoon
 */
public abstract class AbstractRoom{
    private String name;
    private List<IOException> errorArray = new ArrayList();
    private List<Thread> tArray = new ArrayList();
    public AbstractRoom(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public MessageFlag connect(Socket client) {
        Thread t = new Thread(new ListenerThread(client, this));
        t.start();
        return MessageFlag.HANDSHAKE_OK;
    }
    
    abstract public void inputCallback(ClientEvent evt);
    abstract public void errorCallback(IOException ex);
}
