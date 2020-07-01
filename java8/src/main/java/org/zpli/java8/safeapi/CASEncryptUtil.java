package org.zpli.java8.safeapi;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/4/2 18:43
 */
public class CASEncryptUtil {

    // 加密规则
    private static final String RULES = "Sinosun@12345678";

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @return
     */
    public static String encrypt(String content) {
        String result = content;
        try {
            SecretKeySpec key = new SecretKeySpec(RULES.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = content.getBytes("UTF-8");
            byte[] byte_AES = cipher.doFinal(byteContent);
            result = Base64.getEncoder().encodeToString(byte_AES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 解密
     *
     * @param content 待解密内容
     * @return
     */
    public static String decrypt(String content) {
        String result = content;
        try {
            SecretKeySpec key = new SecretKeySpec(RULES.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] byteContent = Base64.getDecoder().decode(content);
            byte[] byte_AES = cipher.doFinal(byteContent);
            result = new String(byte_AES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 主函数
     */
    public static void main(String[] args) throws Exception {
        // sHB6rx7a1WJsRS5U3Hxvew==
        String content = "sinosunts";
        //加密
        System.out.println("加密前：" + content);
        String encryptResult = encrypt(content);
        System.out.println("加密后：" + encryptResult);
        //解密
        String decryptResult = decrypt(encryptResult);
        System.out.println("解密后：" + decryptResult);

    }

}
