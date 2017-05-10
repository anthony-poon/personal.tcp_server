/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.tcp_server;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.anthonypoon.tcp_server.message.HandshakeMessage;
import net.anthonypoon.tcp_server.message.MessageFlag;
import net.anthonypoon.tcp_server.room.AbstractRoom;

/**
 *
 * @author ypoon
 */
public class TcpJsonServer implements Runnable{
    private int port;
    private ServerSocket server;
    private Map<String, AbstractRoom> roomMap = new HashMap();
    private List<IOException> errors = new ArrayList();
    public TcpJsonServer(int port) throws IOException {
        this.port = port;
        
    }
    public void addRoom(AbstractRoom room) {
        roomMap.put(room.getName(), room);
    }
    
    public AbstractRoom getRoom(String roomName) {
        return roomMap.get(roomName);
    }

    @Override
    public void run() {

        try {
            server = new ServerSocket(port);
            System.out.println("Listening on port " + port);
            while (true) {
                Socket client = server.accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter output = new PrintWriter(client.getOutputStream(), true);
                String str = input.readLine();
                Gson gson = new Gson();
                System.out.println("Handshake received");
                try {
                    HandshakeMessage msg = gson.fromJson(str, HandshakeMessage.class);
                    MessageFlag reply = roomMap.get(msg.getDestination()).connect(client);
                    HandshakeMessage replyMsg = new HandshakeMessage();
                    switch (reply) {
                        case HANDSHAKE_OK:                            
                            replyMsg.setFlag(MessageFlag.HANDSHAKE_OK);
                            replyMsg.addPayload("Handshake OK");
                            break;
                    }
                    output.println(replyMsg.toJson());
                } catch (JsonSyntaxException ex ) {
                    System.out.println(str);
                }                    
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public List<IOException> getErrors() {
        return errors;
    }
}
