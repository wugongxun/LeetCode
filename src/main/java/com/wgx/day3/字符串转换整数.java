package com.wgx.day3;

import java.util.ArrayList;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/29 10:08
 */
public class 字符串转换整数 {
    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.equals("")) return 0;
        boolean isPositive = true;
        ArrayList<Character> list = new ArrayList<>();
        char[] charArr = s.toCharArray();
        char ch = charArr[0];
        if (ch == '-') {
            isPositive = false;
        } else if (ch >= 48 && ch <= 57) {
            list.add(ch);
        } else if (ch != '+') {
            return 0;
        }
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i] >= 48 && charArr[i] <= 57) {
                list.add(charArr[i]);
            } else {
                break;
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        int res = 0;
        while (!list.isEmpty()) {
            int i = list.remove(0) - '0';
            int newRes = res * 10 + i;
            if ((newRes - i) / 10 != res || newRes < 0) return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = newRes;
        }
        return isPositive ? res : -res;
    }
}
