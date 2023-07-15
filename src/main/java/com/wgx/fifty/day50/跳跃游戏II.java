package com.wgx.fifty.day50;

/**
 * @author wgx
 * @since 2023/7/13 15:54
 */
public class 跳跃游戏II {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{1, 2, 1, 1, 1}));
        System.out.println(jump(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        int res = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < n - 1; ++i) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                res++;
            }
        }
        return res;
    }
}
