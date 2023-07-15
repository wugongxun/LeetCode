package com.wgx.周赛.第346场周赛;

/**
 * @author wgx
 * @since 2023/5/21 10:32
 */
public class 删除子串后的字符串最小长度 {
    public static void main(String[] args) {
        System.out.println(minLength("ABFCACDB"));
    }

    public static int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "");
            s = s.replace("CD", "");

        }
        return s.length();
    }
}
