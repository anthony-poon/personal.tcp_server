/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.tcp_server.room;

import java.io.OutputStream;

/**
 *
 * @author ypoon
 */
public interface ClientEvent {
    public String getInput();
    public void setInput(String str);
    public OutputStream getOutputStream();
    public void setOutputStream(OutputStream outputStream);
}
