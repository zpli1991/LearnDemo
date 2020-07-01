package org.zpli.socket.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/16 10:15
 */
public class SocketClient2 {

    public static void main(String args[]) {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 与服务端建立连接
            socket = new Socket(host, port);
            // 建立连接后获得输出流
            outputStream = socket.getOutputStream();
            String message = "你好  世界如此美丽";
            outputStream.write(message.getBytes("UTF-8"));
            //通过shutdownOutput告诉服务器已经发送完数据，后续只能接受数据
            socket.shutdownOutput();
            inputStream = socket.getInputStream();
            int len;
            byte[] bytes = new byte[1024];
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, "utf-8"));
            }
            System.out.println("从服务端得到的响应是：" + sb);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
