package com.wgx.day41;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2023/5/23 10:43
 */
public class 受标签影响的最大值 {
    public static void main(String[] args) {
        System.out.println(largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 3, 3, 3, 2}, 3, 2));
    }

    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        var queue = new PriorityQueue<int[]>((o1, o2) -> o2[0] - o1[0]);
        int n = values.length;
        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{values[i], labels[i]});
        }
        var res = 0;
        var count = 0;
        var map = new HashMap<Integer, Integer>();
        while (!queue.isEmpty() && count < numWanted) {
            var cur = queue.poll();
            if (map.getOrDefault(cur[1], 0) < useLimit) {
                count++;
                res += cur[0];
                map.put(cur[1], map.getOrDefault(cur[1], 0) + 1);
            }
        }
        return res;
    }
}
