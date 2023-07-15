package com.wgx.fifty.day43;

/**
 * @author wgx
 * @since 2023/6/14 9:58
 */
public class 二进制字符串前缀一致的次数 {
    public static void main(String[] args) {
        System.out.println(numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
    }


    public static int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        int count = 0, farthest = 0, res = 0;
        for (int i = 0; i < n; ++i) {
            farthest = Math.max(farthest, flips[i]);
            if (farthest == i + 1) {
                ++res;
            }
        }
        return res;
    }

//    public static int numTimesAllBlue(int[] flips) {
//        int n = flips.length;
//        var bits = new boolean[n];
//        int res = 0;
//        for (int i = 0; i < n; ++i) {
//            int flip = flips[i] - 1;
//            bits[flip] = true;
//            var flag = true;
//            for (int j = 0; j < n; j++) {
//                if ((j <= i && !bits[j])
//                        || (j > i && bits[j])) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                ++res;
//            }
//        }
//        return res;
//    }
}
