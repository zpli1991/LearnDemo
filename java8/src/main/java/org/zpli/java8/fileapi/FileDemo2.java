package org.zpli.java8.fileapi;

import java.io.*;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/4/9 9:38
 */
public class FileDemo2 {

    public String readInputStream(InputStream is) throws IOException {
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int len;
        while ((len = is.read(bytes)) != -1) {
            baos.write(bytes, 0, len);
        }
        baos.close();
        return baos.toString();
    }

    public String readInputStream2(InputStream is) throws IOException {
        OutputStream os = new FileOutputStream("");
        return null;
    }

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:\\GitDir\\LearnDemo\\settings.gradle");
        FileDemo2 fileDemo2 = new FileDemo2();
        String result = fileDemo2.readInputStream(is);
        System.out.println(result);
    }

}
