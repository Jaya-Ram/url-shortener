package com.url.shortener.util;

public class Base62Encoder {
    private static final String BASE62="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String encode(Long num){
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            num--;
            int rem = (int) (num % 62);
            sb.append(BASE62.charAt(rem));
            num = num / 62;
        }
        return sb.reverse().toString();
    }
}
