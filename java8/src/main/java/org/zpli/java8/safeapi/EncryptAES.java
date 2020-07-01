package org.zpli.java8.safeapi;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/4/2 14:40
 */

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class EncryptAES {

    // 加密规则
    private static final String RULES = "Sinosun@12345678";

    /**
     * 加密
     * 1.构造密钥生成器
     * 2.根据 RULES 规则初始化密钥生成器
     * 3.产生密钥
     * 4.创建和初始化密码器
     * 5.内容加密
     * 6.返回字符串
     *
     * @param content 需要加密的内容
     * @return
     */
    public static String encrypt(String content) throws Exception {
        //1.构造密钥生成器，指定为AES算法,不区分大小写
        KeyGenerator kGen = KeyGenerator.getInstance("AES");
        //2.根据 RULES 规则初始化密钥生成器，根据传入的字节数组生成一个128位的随机源
        kGen.init(128, new SecureRandom(RULES.getBytes()));
        //3.产生原始对称密钥
        SecretKey secretKey = kGen.generateKey();
        //4.获得原始对称密钥的字节数组
        byte[] enCodeFormat = secretKey.getEncoded();
        //5.根据字节数组生成AES密钥
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        //6.根据指定算法AES生成密码器
        Cipher cipher = Cipher.getInstance("AES");
        //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
        //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
        byte[] byteContent = content.getBytes("utf-8");
        //9.根据密码器的初始化方式--加密：将数据加密
        byte[] byte_AES = cipher.doFinal(byteContent);
        //10.将字符串返回
        return Base64.getEncoder().encodeToString(byte_AES);
    }

    /**
     * 解密
     *
     * @param content 待解密内容
     * @return
     */
    public static String decrypt(String content) throws Exception {
        //1.构造密钥生成器，指定为AES算法,不区分大小写
        KeyGenerator kGen = KeyGenerator.getInstance("AES");
        //2.根据 RULES 规则初始化密钥生成器，根据传入的字节数组生成一个128位的随机源
        kGen.init(128, new SecureRandom(RULES.getBytes()));
        //3.产生原始对称密钥
        SecretKey secretKey = kGen.generateKey();
        //4.获得原始对称密钥的字节数组
        byte[] enCodeFormat = secretKey.getEncoded();
        //5.根据字节数组生成AES密钥
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        //6.根据指定算法AES生成密码器
        Cipher cipher = Cipher.getInstance("AES");
        //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
        byte[] byteContent = Base64.getDecoder().decode(content);
        byte[] byte_AES = cipher.doFinal(byteContent);
        return new String(byte_AES);
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
        String encryptResult = encrypt(content);
        // String result = parseByte2HexStr(encryptResult);
        System.out.println("加密后：" + encryptResult);
        //解密
        // byte[] bytes = parseHexStr2Byte(result);
        String decryptResult = decrypt(encryptResult);
        System.out.println("解密后：" + decryptResult);

    }

}