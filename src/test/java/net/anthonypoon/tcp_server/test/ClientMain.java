/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.tcp_server.test;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import net.anthonypoon.tcp_server.TcpJsonClient;

/**
 *
 * @author ypoon
 */
public class ClientMain {
    public static int numOfTestClient = 2;
    public static int numOfTestMessage = 5;
    private static int port = 21196;
    private static String host = "localhost";
    public static void main(String[] args) throws IOException, InterruptedException {
        TcpJsonClient client = new TcpJsonClient(host, port);
        client.handshake("room_1");
        Scanner s = new Scanner(System.in);
        PrintWriter w = new PrintWriter(client.getOutput(), true);
        while (true) {
            w.println(s.nextLine());
        }
    }
}
