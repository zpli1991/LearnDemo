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
public class ServerSocketDemo2 {

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
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                sb.append(new String(bytes, 0, len, "UTF-8"));
            }
            outputStream = socket.getOutputStream();
            outputStream.write("我已经收到客户端发送的数据，这是我的响应结果".getBytes("utf-8"));
            System.out.println("get message from client: " + sb);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
                if(null != outputStream){
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
