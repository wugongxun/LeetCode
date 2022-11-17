package com.wgx.day2;

import java.util.ArrayList;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/28 10:46
 */
public class 整数反转 {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int mod = x % 10;
            int newRes = res * 10 + mod;
            if ((newRes - mod) / 10 != res) {
                return 0;
            }
            res = newRes;
            x /= 10;
        }
        return res;

//        if (x == 0) return 0;
//        boolean isPositive = x > 0 ? true : false;
//        double i = 10;
//        ArrayList<Integer> list = new ArrayList<>();
//        x = Math.abs(x);
//        while (true) {
//            if (i / 10 > x) break;
//            int mod = (int) ((x % i) / (i / 10));
//            list.add(mod);
//            i *= 10;
//        }
//        double res = 0d;
//        for (double j = Math.pow(10, list.size() - 1); j >= 1; j /= 10) {
//            Integer integer = list.remove(0);
//            res += integer * j;
//        }
//        if (!isPositive) res = -res;
//        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
//        return (int) res;
    }
}
