package com.wgx.fifty.day28;

/**
 * @author wgx
 * @since 2023/3/9 11:04
 *
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 */
public class 阶乘后的零 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5027));
    }

    public static int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
