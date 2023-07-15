package com.wgx.周赛.第332场周赛;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/2/12 10:41
 *
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。
 *
 * 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：
 *
 * 0 <= i < j < n，且
 * lower <= nums[i] + nums[j] <= upper
 */
public class 统计公平数对的数目 {
    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{0,0,0,0,0,0}, 0, 0));
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0, j = nums.length - 1, k = nums.length - 1; i < nums.length; i++) {
            for (; j >= 0 && nums[i] + nums[j] >= lower; j--) {
            }
            for (; k >= 0 && nums[i] + nums[k] > upper; k--) {
            }
            //排除nums[i] + nums[i]的情况
            res += k - j - (i > j && i <= k ? 1 : 0);
        }
        //公平数对之间相互统计了两次，除以2为单次统计
        return res / 2;
    }
}
