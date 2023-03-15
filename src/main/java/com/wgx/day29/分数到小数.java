package com.wgx.day29;

import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/3/14 11:06
 */
public class 分数到小数 {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1, Integer.MIN_VALUE));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 1) {
            return String.valueOf(numerator);
        }
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        var sb = new StringBuilder();
        var map = new HashMap<Long, Integer>();
        sb.append(n / d);
        long mod = n % d;
        if (mod != 0) {
            sb.append(".");
        }
        while (mod != 0) {
            sb.append(mod * 10 / d);
            mod = mod * 10 % d;
            if (map.containsKey(mod)) {
                sb.insert(map.get(mod), "(");
                sb.append(")");
                break;
            }
            map.put(mod, sb.length());
        }

        return ((denominator > 0 ^ numerator > 0) ? "-" : "" ) + sb;
    }
}
