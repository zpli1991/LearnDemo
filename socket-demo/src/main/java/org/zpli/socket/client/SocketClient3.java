package org.zpli.socket.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/16 10:15
 */
public class SocketClient3 {

    public static void main(String args[]) {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String message = "你好  我是发送的数据";
            //首先需要计算得知消息的长度
            byte[] sendBytes = message.getBytes("UTF-8");
            //然后将消息的长度优先发送出去
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            //然后将消息再次发送出去
            outputStream.write(sendBytes);
            outputStream.flush();
            //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
            message = "第二条消息";
            sendBytes = message.getBytes("UTF-8");
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            outputStream.write(sendBytes);
            outputStream.flush();
            //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
            message = "the third message!";
            sendBytes = message.getBytes("UTF-8");
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            outputStream.write(sendBytes);

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
