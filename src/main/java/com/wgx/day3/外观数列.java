package com.wgx.day3;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/30 9:46
 */
public class 外观数列 {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        String preStr = countAndSay(n - 1);
        char[] charArr = preStr.toCharArray();
        StringBuilder builder = new StringBuilder();
        int i = 1, j = 0;
        for (; i < charArr.length; i++) {
            if (charArr[i] != charArr[j]) {
                builder.append(i - j).append(charArr[j]);
                j = i;
            }
        }
        if (i != j)
            builder.append(i - j).append(charArr[j]);
        return builder.toString();
    }
}
