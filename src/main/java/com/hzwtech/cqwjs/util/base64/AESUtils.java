package com.hzwtech.cqwjs.util.base64;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */
public class AESUtils {
    public static final String ECB_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static void main(String[] args) throws Exception {
        String content = "这是一个测试字符串";
        System.out.println("加密前：" + content);
        String key = "982922d3680911e6";
        System.out.println("加密密钥：" + key);
        String encrypt = aesEncrypt(content, key);
        System.out.println("加密后：" + encrypt);
        String decrypt = aesDecrypt(encrypt, key);
        System.out.println("解密后：" + decrypt);
    }

    public static String base64Encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    public static byte[] base64Decode(String base64Code) throws Exception {
        return Base64.decodeBase64(base64Code);
    }

    /**
     * AES/ECB/PKCS5Padding
     *
     * @param input      待加密的明文
     * @param encryptKey 加密密钥
     * @return 加密后的密文 base64编码
     */
    public static String aesEncrypt(String input, String encryptKey) throws Exception {
        SecretKeySpec skey = new SecretKeySpec(encryptKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(ECB_CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, skey);
        return base64Encode(cipher.doFinal(input.getBytes()));
    }

    /**
     * 解密方法暂时不需要使用，仅作验证加密结果用途
     **/
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        byte[] input = base64Decode(encryptStr);
        SecretKeySpec skey = new SecretKeySpec(decryptKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(ECB_CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, skey);
        return new String(cipher.doFinal(input));
    }

    /**
     * md5加密
     *
     * @param content
     * @return
     */
    public static String md5Encrypt(String content) {
        try {
            return DigestUtils.md5Hex(content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
