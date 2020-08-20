package org.zpli.java8.socketapi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/7/2 15:24
 */
public class SocketDemo {

    public void createSocket() throws IOException {
       Socket socket = new Socket();
       socket.setReuseAddress(true);
    }

    public void createServerSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.setReuseAddress(true);


        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_READ);

        while (true){
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            // if ()


        }
    }
}
