package com.wgx.day43;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wgx
 * @since 2023/6/14 11:33
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        var deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        var res = new int[n - k + 1];
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
