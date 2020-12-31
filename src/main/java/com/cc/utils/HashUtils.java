package com.cc.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: CC
 * @date: 2020/12/31 14:53
 * @Description: 获取Hash值 SHA256
 */

public class HashUtils {

    /**
     * 获取Hash值
     * @param key 需要获取Hash的字符
     * @return
     */
    public static String getHashValue(String key) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            mDigest.update(key.getBytes());
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(key.hashCode());
        }
        return cacheKey;
    }

    /**
     * 转换为字符串
     * @param bytes
     * @return
     */
    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();

    }
}
