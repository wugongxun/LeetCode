package com.wgx.hundred.day56;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/7/28 17:28
 */
public class 比特位计数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(100)));
    }

    //动态规划——最低设置位
    public static int[] countBits(int n) {
        var res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i - 1 & i] + 1;
        }
        return res;
    }

    //动态规划——最低有效位
//    public static int[] countBits(int n) {
//        var res = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            res[i] = res[i >> 1] + (i & 1);
//        }
//        return res;
//    }

    //动态规划——最高有效位
//    public static int[] countBits(int n) {
//        var res = new int[n + 1];
//        int highBit = 0;
//        for (int i = 1; i <= n; i++) {
//            if ((i - 1 & i) == 0) {
//                highBit = i;
//            }
//            res[i] = res[i - highBit] + 1;
//        }
//        return res;
//    }


    //Brian Kernighan 算法
//    public static int[] countBits(int n) {
//        var res = new int[n + 1];
//        for (int i = 0; i <= n; i++) {
//            int ones = 0;
//            int x = i;
//            while (x > 0) {
//                x &= (x - 1);
//                ones++;
//            }
//            res[i] = ones;
//        }
//        return res;
//    }
}
