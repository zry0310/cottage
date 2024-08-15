package com.rycode.cottage.utils;
 
import java.util.Random;

/**
 * 字符串工具类
 */
public class StrUtil {
 
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+";
 
    /**
     * 生成指定长度的复杂随机字符串
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String getComplexRandomString(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("随机字符串长度必须大于等于1");
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
 
}