package com.wgx.fifty.day23;

/**
 * @author wgx
 * @since 2023/2/16 10:59
 */
public class 跳跃游戏 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 0, 0}));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return true;
        }
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
            } else {
                return false;
            }
            if (max >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
