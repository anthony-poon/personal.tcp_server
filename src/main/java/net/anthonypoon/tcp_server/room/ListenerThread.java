/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.tcp_server.room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.anthonypoon.tcp_server.example.chat.InputEvent;

/**
 *
 * @author ypoon
 */
public class ListenerThread implements Runnable{
    private Socket socket;
    private AbstractRoom room;
    public ListenerThread(Socket socket, AbstractRoom room) {
        this.socket = socket;
        this.room = room;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                InputEvent evt = new InputEvent();
                evt.setInput(br.readLine());
                evt.setOutputStream(socket.getOutputStream());
                room.inputCallback(evt);
            }
        } catch (IOException ex) {
            room.errorCallback(ex);
        }
    }
}
