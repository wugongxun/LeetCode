package com.wgx.hundred.day57;

/**
 * @author wgx
 * @since 2023/7/29 17:29
 */
public class 分数加减运算 {
    public static void main(String[] args) {
//        System.out.println(fractionAddition("-1/2+1/2"));
//        System.out.println(fractionAddition("1/3-1/2"));
//        System.out.println(fractionAddition("5/3+1/3"));
        System.out.println(fractionAddition("-5/2+10/3+7/9"));
    }

    public static String fractionAddition(String expression) {
        int n = expression.length();
        int i = 0;
        int sign = 1;
        if (expression.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int up = 0;
        while (i < n && Character.isDigit(expression.charAt(i))) {
            up = up * 10 + (expression.charAt(i++) - '0');
        }
        up *= sign;
        i++;
        int down = 0;
        while (i < n && Character.isDigit(expression.charAt(i))) {
            down = down * 10 + (expression.charAt(i++) - '0');
        }
        while (i < n) {
            sign = expression.charAt(i++) == '-' ? -1 : 1;
            int up1 = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                up1 = up1 * 10 + (expression.charAt(i++) - '0');
            }
            up1 *= sign;
            i++;
            int down1 = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                down1 = down1 * 10 + (expression.charAt(i++) - '0');
            }
            up = up * down1 + up1 * down;
            down *= down1;
        }
        if (up % down == 0) {
            return (up / down) + "/1";
        } else {
            int a = Math.abs(up);
            int b = down;
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            up /= a;
            down /= a;
        }
        return up + "/" + down;
    }
}
