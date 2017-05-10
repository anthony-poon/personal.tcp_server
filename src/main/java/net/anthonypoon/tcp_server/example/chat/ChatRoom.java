/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.tcp_server.example.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.anthonypoon.tcp_server.message.HandshakeMessage;
import net.anthonypoon.tcp_server.message.MessageFlag;
import net.anthonypoon.tcp_server.room.AbstractRoom;
import net.anthonypoon.tcp_server.room.ClientEvent;

/**
 *
 * @author ypoon
 */
public class ChatRoom extends AbstractRoom{
    public List<String> messageBuffer = new ArrayList();
    public List<Socket> clientList = new ArrayList();
    public List<Thread> clientThread = new ArrayList();
    public ChatRoom(String name) {
        super(name);
    }

    @Override
    public void inputCallback(ClientEvent evt) {
        System.out.println(evt.getInput());
        PrintWriter w = new PrintWriter(evt.getOutputStream());
        w.println("Message received.");
    }

    @Override
    public void errorCallback(IOException ex) {
        ex.printStackTrace();
    }
}
