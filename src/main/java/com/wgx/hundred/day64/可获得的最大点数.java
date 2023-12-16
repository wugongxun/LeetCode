package com.wgx.hundred.day64;

/**
 * @author wgx
 * @since 2023/12/3 13:08
 */
public class 可获得的最大点数 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        var prefix = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + cardPoints[i];
        }
        int res = Integer.MAX_VALUE;
        int sum = prefix[n];
        for (int i = 0; i <= k; ++i) {
            res = Math.min(res, prefix[i + (n - k)] - prefix[i]);
        }
        return sum - res;
    }
}
