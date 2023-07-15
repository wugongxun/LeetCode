package com.wgx.周赛.第353场周赛;

/**
 * @author wgx
 * @since 2023/7/9 11:03
 */
public class 构造最长非递减子数组 {
    public static void main(String[] args) {
//        System.out.println(maxNonDecreasingLength(new int[]{5, 18, 5}, new int[]{17, 5, 8}));
//        System.out.println(maxNonDecreasingLength(new int[]{8, 7, 4}, new int[]{13, 4, 4}));
//        System.out.println(maxNonDecreasingLength(new int[]{11, 7, 7, 9}, new int[]{19, 19, 1, 7}));
        System.out.println(maxNonDecreasingLength(new int[]{8, 5, 8, 6}, new int[]{20, 8, 10, 8}));
    }

    public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        var nums = new int[][]{nums1, nums2};
        var dp = new int[n][2];
        dp[0] = new int[]{1, 1};
        for (int i = 1; i < n; i++) {
            dp[i] = new int[]{1, 1};
            for (int j = 0; j < 2; j++) {
                if (nums1[i - 1] <= nums[j][i]) {
                    dp[i][j] = dp[i - 1][0] + 1;
                }
                if (nums2[i - 1] <= nums[j][i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][1] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }

//    public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        var dp = new int[n][4];
//        dp[0] = new int[]{Math.max(nums1[0], nums2[0]), 1, Math.min(nums1[0], nums2[0]), 1};
//        int res = 1;
//        for (int i = 1; i < n; i++) {
//            int max = Math.max(nums1[i], nums2[i]);
//            int min = Math.min(nums1[i], nums2[i]);
//            if (min >= dp[i - 1][0]) {
//                dp[i][0] = min;
//                dp[i][1] = dp[i - 1][1] + 1;
//            } else if (max >= dp[i - 1][0]) {
//                dp[i][0] = max;
//                dp[i][1] = dp[i - 1][1] + 1;
//            } else {
//                dp[i][0] = max;
//                dp[i][1] = 1;
//            }
//            if (min >= dp[i - 1][2]) {
//                dp[i][2] = min;
//                dp[i][3] = dp[i - 1][3] + 1;
//            } else if (max >= dp[i - 1][2]) {
//                dp[i][2] = max;
//                dp[i][3] = dp[i - 1][3] + 1;
//            } else {
//                dp[i][2] = min;
//                dp[i][3] = 1;
//            }
//            if (dp[i][0] == dp[i][2]) {
//                dp[i][1] = Math.max(dp[i][1], dp[i][3]);
//                dp[i][2] = min;
//                dp[i][3] = 1;
//            }
//            res = Math.max(res, Math.max(dp[i][1], dp[i][3]));
//        }
//        return res;
//    }
}
