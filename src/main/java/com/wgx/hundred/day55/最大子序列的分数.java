package com.wgx.hundred.day55;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2023/7/26 15:28
 */
public class 最大子序列的分数 {

    @Test
    public void test() {
        System.out.println(maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3));
//        System.out.println(maxScore(new int[]{44, 10, 25, 0, 25, 49, 0}, new int[]{18, 39, 15, 31, 43, 20, 45}, 6));
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        var ids = new Integer[n];
        Arrays.setAll(ids, i -> i);
        Arrays.sort(ids, (a, b) -> nums2[b] - nums2[a]);
        var pq = new PriorityQueue<Integer>();
        long sum = 0;
        for (int i = 0; i < k - 1; ++i) {
            sum += nums1[ids[i]];
            pq.offer(nums1[ids[i]]);
        }
        long res = 0;
        for (int i = k - 1; i < n; ++i) {
            int id = ids[i];
            sum += nums1[id];
            pq.offer(nums1[id]);
            res = Math.max(res, sum * nums2[id]);
            sum -= pq.poll();
        }
        return res;
    }
}
