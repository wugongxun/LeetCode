package com.wgx.day37;

/**
 * @author wgx
 * @since 2023/4/26 10:36
 */
public class 两个非重叠子数组的最大和 {
    public static void main(String[] args) {
        System.out.println(maxSumTwoNoOverlap(new int[]{1,0,3}, 1, 2));
    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        var prefix = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int res = 0, maxA = 0, maxB = 0;
        for (int i = firstLen + secondLen; i <= n; ++i) {
            //左a右b
            maxA = Math.max(maxA, prefix[i - secondLen] - prefix[i - secondLen - firstLen]);
            //左b右a
            maxB = Math.max(maxB, prefix[i - firstLen] - prefix[i - firstLen - secondLen]);
            res = Math.max(res, Math.max(maxA + prefix[i] - prefix[i - secondLen], maxB + prefix[i] - prefix[i - firstLen]));
        }
        return res;
    }

//    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
//        int n = nums.length;
//        var prefix = new int[n + 1];
//        for (int i = 0; i < n; ++i) {
//            prefix[i + 1] = prefix[i] + nums[i];
//        }
//
//        int res = 0;
//        for (int i = 0; i <= n - firstLen; ++i) {
//            int sum1 = prefix[i + firstLen] - prefix[i];
//            int sum2 = 0;
//            for (int j = 0; j <= n - secondLen; ++j) {
//                if (j + secondLen < i || j >= i + firstLen) {
//                    sum2 = Math.max(sum2, prefix[j + secondLen] - prefix[j]);
//                }
//            }
//            res = Math.max(sum1 + sum2, res);
//        }
//        return res;
//    }
}
