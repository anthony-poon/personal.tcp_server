/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.tcp_server.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import net.anthonypoon.tcp_server.TcpJsonClient;

/**
 *
 * @author ypoon
 */
public class ChatClient extends TcpJsonClient{

    public ChatClient(String host, int port) throws IOException {
        super(host, port);
    }
    
    public String write(String str) throws IOException {
        Socket client = this.getSocket();
        PrintWriter toServer = new PrintWriter(client.getOutputStream(), true);
        toServer.println(str);
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String reply = null;
        String line;
        while ((line = br.readLine()) != null) {
            reply = reply + "\n" + line;
        }
        return reply;
    }
}
