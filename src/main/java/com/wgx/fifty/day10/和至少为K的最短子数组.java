package com.wgx.fifty.day10;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/26 10:11
 */
public class 和至少为K的最短子数组 {
    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{-100000, -100000, -100000, -100000, -100000, -100000, -100000, -100000, -100000, -100000, -100000, -100000}, 3));
    }

    public static int shortestSubarray(int[] nums, int k) {
        int len = nums.length, ans = len + 1;
        //前缀和数组
        long[] preSum = new long[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <= len; i++) {
            while (!deque.isEmpty() && (preSum[i] - preSum[deque.peekFirst()] >= k)) {
                //如果出现了大于等于k的情况，直接将队首的元素抛出，因为之后不会再出现以这个元素为队首的更短子数组
                ans = Math.min(ans, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()]) {
                //如果当前的前缀和小于等于队尾的，则后续如果出现preSum[x]-preSum[i] >= k，则一定不会有比x到i的更短的子数组，比preSum[i]大的前缀和可以直接抛出
                //也就是保持队列的单调性
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return ans > len ? -1 : ans;

//        int i = 0, j = 1, res = nums.length + 1;
//        int sum = nums[0];
//        while (i < nums.length) {
//            if (sum >= k) {
//                res = Math.min(res, j - i);
//                sum -= nums[i];
//                i++;
//            } else if (sum > 0 && j < nums.length) {
//                sum += nums[j];
//                j++;
//            } else if (sum <= 0 && j < nums.length) {
//                i = j;
//                j++;
//                sum = nums[i];
//            } else {
//                sum -= nums[i];
//                i++;
//            }
//        }
//        return res <= nums.length ? res : -1;
    }
}
