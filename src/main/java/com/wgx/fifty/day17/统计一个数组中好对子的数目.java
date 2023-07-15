package com.wgx.fifty.day17;

import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/1/17 9:19
 *
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 *
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 */
public class 统计一个数组中好对子的数目 {
    public static void main(String[] args) {
        System.out.println(countNicePairs(new int[]{42,11,1,97}));
    }



    public static int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i], j = 0;
            while (temp > 0) {
                j = j * 10 + temp % 10;
                temp /= 10;
            }
            res = (res + map.getOrDefault(nums[i] - j, 0)) % MOD;
            map.put(nums[i] - j, map.getOrDefault(nums[i] - j, 0) + 1);
        }
        return res;
    }
}
