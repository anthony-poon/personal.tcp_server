/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.tcp_server;

import net.anthonypoon.tcp_server.message.HandshakeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import net.anthonypoon.tcp_server.message.MessageFlag;

/**
 *
 * @author ypoon
 */
public class TcpJsonClient {
    private String host;
    private int port;
    private Socket socket;
    private OutputStream output;
    private InputStream input;
    public TcpJsonClient(String host, int port) throws IOException {
        this.host = host;
        this.port = port;        
    }
    
    public void handshake(String destination) throws IOException {
        HandshakeMessage msg = new HandshakeMessage();
        msg.setFlag(MessageFlag.HANDSHAKE_REQUEST);
        msg.setDestination(destination);
        socket = new Socket(host, port);
        output = socket.getOutputStream();
        input = socket.getInputStream();
        PrintWriter w = new PrintWriter(output, true);
        w.println(msg.toJson());        
    }

    public OutputStream getOutput() {
        return output;
    }

    public InputStream getInput() {
        return input;
    } 
    
    public Socket getSocket() {
        return socket;
    }
    
    public void close() throws IOException {
        socket.close();
    }
}
