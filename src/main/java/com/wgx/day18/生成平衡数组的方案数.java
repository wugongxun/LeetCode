package com.wgx.day18;

/**
 * @author wgx
 * @since 2023/1/28 21:09
 *
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 *
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 *
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 *
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 */
public class 生成平衡数组的方案数 {
    public static void main(String[] args) {
        System.out.println(waysToMakeFair(new int[]{1, 1, 1}));
    }

    public static int waysToMakeFair(int[] nums) {
        int len = nums.length;
        //奇数和
        int[] preOddSum = new int[len];
        //偶数和
        int[] preEvenSum = new int[len];
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
            preOddSum[i] = oddSum;
            preEvenSum[i] = evenSum;
        }
        int res = 0;
        if (preEvenSum[len - 1] - nums[0] == preOddSum[len - 1]) {
            res++;
        }
        for (int i = 1; i < len; i++) {
            int odd = preOddSum[i - 1] + preEvenSum[len - 1] - preEvenSum[i];
            int even = preEvenSum[i - 1] + preOddSum[len - 1] - preOddSum[i];
            if (odd == even) {
                res++;
            }
        }
        return res;
    }
}
