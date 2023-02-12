package com.wgx.第332场周赛;

/**
 * @author wgx
 * @since 2023/2/12 10:36
 */
public class 找出数组的串联值 {
    public static void main(String[] args) {
        System.out.println(findTheArrayConcVal(new int[]{5,14,13,8,12}));
    }

    public static long findTheArrayConcVal(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len / 2; i++) {
            String left = "" + nums[i];
            String right = "" + nums[len - i - 1];
            res += Integer.parseInt(left + right);
        }
        if (len % 2 != 0) {
            res += nums[len / 2 + 1];
        }
        return res;
    }
}
