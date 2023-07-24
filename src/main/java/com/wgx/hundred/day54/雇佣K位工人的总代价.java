package com.wgx.hundred.day54;

import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2023/7/24 17:14
 */
public class 雇佣K位工人的总代价 {
    public static void main(String[] args) {
        System.out.println(totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
//        System.out.println(totalCost(new int[]{31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58}, 11, 2));
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        var pq = new PriorityQueue<Integer>((a, b) -> {
            if (costs[a] != costs[b])
                return costs[a] - costs[b];
            else
                return a - b;
        });
        int left = 0, right = n - 1;
        while (left < candidates && left <= right) {
            pq.offer(left);
            if (left != right) {
                pq.offer(right);
            }
            left++;
            right--;
        }
        long res = 0;
        while (k > 0) {
            k--;
            int poll = pq.poll();
            res += costs[poll];
            if (left <= right) {
                if (poll < left) {
                    pq.offer(left++);
                } else {
                    pq.offer(right--);
                }
            }
        }
        return res;
    }
}
