package com.wgx.周赛.第337场周赛;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/3/19 10:34
 */
public class 奇偶位数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(evenOddBit(17)));
    }

    public static int[] evenOddBit(int n) {
        var res = new int[2];
        for (int i = 0; n != 0; n >>= 1, i ^= 1) {
            res[i] += n & 1;
        }
        return res;
    }
}
