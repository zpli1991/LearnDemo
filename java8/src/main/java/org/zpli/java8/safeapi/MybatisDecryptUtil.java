// package org.zpli.java8.safeapi;
//
// import org.apache.commons.io.Charsets;
//
// import javax.crypto.Cipher;
// import javax.crypto.spec.SecretKeySpec;
// /**
//  * @Copyright: Copyright (c) 兆日科技股份有限公司  2020
//  * @author xiela
//  * @date 2020/3/30,17:32
//  */
//
//
// /**
//  *@program: ss-框架-1.x
//  *@description: mybatis 加解密工具类
//  *@author: xiela
//  *@create: 2020-03-30 17:32
//  */
// public class MybatisDecryptUtil {
//     private static final String KEY = "Sinosun@12345678";
//     /*
//     * @Description: AES加密方法
//      * @param String utf-8编码的字符串
//     * @return  加密结果
//     * @author xiela
//     * @date 2020/3/30 18:02
//     */
//     public static String aesEncrypt(String data)
//     {
//         try
//         {
//             byte[] words = data.getBytes(Charsets.UTF_8);
//             SecretKeySpec key = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");
//             Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//             cipher.init(Cipher.ENCRYPT_MODE, key);
//             return Base64.encodeBase64String(cipher.doFinal(words));
//         }
//         catch (Exception e)
//         {
//             BaseLog.getErrorLog().error("AesCrypto.encrypt error", e);
//         }
//         return "";
//     }
//     /*
//     * @Description: AES解密方法
//      * @param String 二进制经过base64加密的密文
//     * @return  解密结果
//     * @author xiela
//     * @date 2020/3/30 18:02
//     */
//     public static String aesDecrypt(String data)
//     {
//         try
//         {
//             Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//             byte[] words = Base64.decodeBase64(data);
//             SecretKeySpec key = new SecretKeySpec(KEY.getBytes(Charsets.UTF_8), "AES");
//             cipher.init(Cipher.DECRYPT_MODE, key);
//             return new String(cipher.doFinal(words), Charsets.UTF_8);
//         }
//         catch (Exception e)
//         {
//             BaseLog.getErrorLog().error("AesCrypto.decrypt error", e);
//         }
//         return "";
//     }
//     /*
//      * @Description: DES加密方法
//      * @param String utf-8编码的字符串
//      * @return  加密结果
//      * @author xiela
//      * @date 2020/3/30 18:02
//      */
//     public static String desEncrypt(String data)
//     {
//         try
//         {
//             byte[] words = data.getBytes(Charsets.UTF_8);
//             SecretKeySpec key = new SecretKeySpec(KEY.substring(0,8).getBytes("UTF-8"), "DES");
//             Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//             cipher.init(Cipher.ENCRYPT_MODE, key);
//             return Base64.encodeBase64String(cipher.doFinal(words));
//         }
//         catch (Exception e)
//         {
//             BaseLog.getErrorLog().error("DesCrypto.encrypt error", e);
//         }
//         return "";
//     }
//
//
//
//     /*
//      * @Description: AES解密方法
//      * @param String 二进制经过base64加密的密文
//      * @return  解密结果
//      * @author xiela
//      * @date 2020/3/30 18:02
//      */
//     public static String desDecrypt(String data)
//     {
//         try
//         {
//             Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//             byte[] words = Base64.decodeBase64(data);
//
//             SecretKeySpec key = new SecretKeySpec(KEY.substring(0,8).getBytes(Charsets.UTF_8), "DES");
//             cipher.init(Cipher.DECRYPT_MODE, key);
//             return new String(cipher.doFinal(words), Charsets.UTF_8);
//         }
//         catch (Exception e)
//         {
//             BaseLog.getErrorLog().error("DesCrypto.decrypt error", e);
//         }
//         return "";
//     }
//
//     public static void main(String[] args) {
//         String pwd="L5lGw3YaDWS8kGWOAr+uWA==";
//         // AES 加密后的结果为 kpPeIQ9FJ+NC93WEZL0+Cw==
//         //String pwd="kpPeIQ9FJ+NC93WEZL0+Cw==";
//         //System.out.println(aesEncrypt(pwd));
//         //System.out.println(aesDecrypt(pwd));
//         // DES 加密后的结果为 L5lGw3YaDWS8kGWOAr+uWA==
//         //System.out.println(desEncrypt(pwd));
//         System.out.println(desDecrypt(pwd));
//     }
// }
