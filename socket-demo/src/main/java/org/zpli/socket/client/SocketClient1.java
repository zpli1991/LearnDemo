package org.zpli.socket.client;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/16 10:04
 */
public class SocketClient1 {
    public static void main(String args[]) {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 与服务端建立连接
            socket = new Socket(host, port);
            // 建立连接后获得输出流
            outputStream = socket.getOutputStream();
            String message = "你好  世界如此美丽";
            outputStream.write(message.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
                if (null != socket) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
