/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.tcp_server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.anthonypoon.tcp_server.example.chat.ChatRoom;

/**
 *
 * @author ypoon
 */
public class ServerMain {
    private static int port = 21196;
    private static String host = "localhost";
    private static int numOfTestClient = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {        
        TcpJsonServer server = new TcpJsonServer(port);
        server.addRoom(new ChatRoom("room_1"));
        server.run();
    }
    
}
