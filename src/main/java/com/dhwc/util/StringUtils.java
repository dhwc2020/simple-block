package com.dhwc.util;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * @author dhwc
 * @create 2022-09-30 16:04
 */
public class StringUtils {
    public static String applySha256(String source){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(source.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                String hexString = Integer.toHexString(0xFF & aByte);
                if (hexString.length() == 1) sb.append("0");
                sb.append(hexString);
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
