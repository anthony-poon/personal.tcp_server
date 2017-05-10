/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.tcp_server.example.chat;

import java.io.InputStream;
import java.io.OutputStream;
import net.anthonypoon.tcp_server.room.ClientEvent;

/**
 *
 * @author ypoon
 */
public class InputEvent implements ClientEvent{
    private String input;
    private OutputStream outputStream;

    @Override
    public String getInput() {
        return input;
    }

    @Override
    public void setInput(String str) {
        this.input = str;
    }

    @Override
    public OutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    
}
