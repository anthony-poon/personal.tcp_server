/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.tcp_server.message;

/**
 *
 * @author ypoon
 */
public enum MessageFlag {
    NULL_FLAG,
    HANDSHAKE_REQUEST,
    HANDSHAKE_OK,
    HANDSHAKE_DENY,
}
