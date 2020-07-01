package org.zpli.socket.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/16 10:12
 */
public class ServerSocketDemo3 {

    public static void main(String[] args) {
        // 监听指定的端口
        int port = 55533;
        ServerSocket server = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            server = new ServerSocket(port);

            // server将一直等待连接的到来
            System.out.println("server将一直等待连接的到来");
            socket = server.accept();
            // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            inputStream = socket.getInputStream();
            byte[] bytes;
            // 因为可以复用Socket且能判断长度，所以可以一个Socket用到底
            while (true) {
                // 首先读取两个字节表示的长度
                int first = inputStream.read();
                //如果读取的值为-1 说明到了流的末尾，Socket已经被关闭了，此时将不能再去读取
                if (first == -1) {
                    break;
                }
                int second = inputStream.read();
                int length = (first << 8) + second;
                // 然后构造一个指定长的byte数组
                bytes = new byte[length];
                // 然后读取指定长度的消息即可
                inputStream.read(bytes);
                System.out.println("get message from client: " + new String(bytes, "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != outputStream) {
                    outputStream.close();
                }
                if (null != socket) {
                    socket.close();
                }
                if (null != server) {
                    server.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
