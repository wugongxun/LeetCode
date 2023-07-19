package com.wgx.hundred.day52;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2023/7/18 20:11
 */
public class 包含每个查询的最小区间 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minInterval(new int[][]{
                {1, 4}, {2, 4}, {3, 6}, {4, 4}
        }, new int[]{2, 3, 4, 5})));
    }

    public static int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;
        var qIndex = new Integer[m];
        Arrays.setAll(qIndex, i -> i);
        Arrays.sort(qIndex, Comparator.comparingInt(i -> queries[i]));
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(i -> i[0]));
        var res = new int[m];
        Arrays.fill(res, -1);
        int i = 0;
        for (var q : qIndex) {
            while (i < n && queries[q] >= intervals[i][0]) {
                pq.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][0], intervals[i][1]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[2] < queries[q]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res[q] = pq.peek()[0];
            }
        }
        return res;
    }
}
