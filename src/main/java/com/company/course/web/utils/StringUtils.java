package com.company.course.web.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {
    private static final String salt = "small@_@origin";

    // 加密密码
    public static String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String str = password + salt;
        md.update(str.getBytes());
        String res = new BigInteger(1, md.digest()).toString(16);
        return res;
    }

    // 产生token
    public static String generateToken(Integer uid) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String str = uid.toString() + salt + System.currentTimeMillis();
        md.update(str.getBytes());
        String res = new BigInteger(1, md.digest()).toString(16);
        return res;
    }

    // 判断字符串为是否为空
    public static boolean isEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
