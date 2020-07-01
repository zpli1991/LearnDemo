package org.zpli.java8.safeapi;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/4/2 14:34
 */
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDES {

    private static final String KEY = "Hello Ketty";

    /**
     * DES 加密
     * @param content
     * @return
     */
    public static byte[] desEncrypt(String content) {
        try {
            KeyGenerator kGen = KeyGenerator.getInstance("DES");
            kGen.init(56, new SecureRandom(KEY.getBytes()));
            SecretKey secretKey = kGen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "DES");
            Cipher cipher = Cipher.getInstance("DES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * DES 解密
     * @param content
     * @return
     */
    public static byte[] desDecrypt(byte[] content) throws Exception {
        KeyGenerator kGen = KeyGenerator.getInstance("DES");
        kGen.init(56, new SecureRandom(KEY.getBytes()));
        SecretKey secretKey = kGen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "DES");
        Cipher cipher = Cipher.getInstance("DES"); // 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key); // 初始化
        byte[] result = cipher.doFinal(content); // 解密
        return result;
    }


    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 主函数
     */
    public static void main(String[] args) throws Exception {

        String content = "Hello World!";
        //加密
        System.out.println("加密前：" + content);
        byte[] encryptResult = desEncrypt(content);
        String result = parseByte2HexStr(encryptResult);
        System.out.println("加密后：" + result);
        //解密
        byte[] bytes = parseHexStr2Byte(result);
        byte[] decryptResult = desDecrypt(bytes);
        System.out.println("解密后：" + new String(decryptResult));
    }
}
