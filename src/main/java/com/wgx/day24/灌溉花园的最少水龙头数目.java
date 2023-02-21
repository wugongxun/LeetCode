package com.wgx.day24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2023/2/21 10:08
 * <p>
 * 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
 * <p>
 * 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
 * <p>
 * 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
 * <p>
 * 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
 */
public class 灌溉花园的最少水龙头数目 {
    public static void main(String[] args) {
        System.out.println(minTaps(5, new int[]{3,4,1,1,0,0}));
    }

    public static int minTaps(int n, int[] ranges) {
        var rightMost = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            rightMost[i] = i;
        }

        for (int i = 0; i <= n; i++) {
            int start = Math.max(i - ranges[i], 0);
            int end = Math.min(i + ranges[i], n);
            rightMost[start] = Math.max(rightMost[start], end);
        }

        int last = 0, res = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            last = Math.max(last, rightMost[i]);
            if (last == i) {
                return -1;
            }
            if (i == pre) {
                res++;
                pre = last;
            }
        }
        return res;


//        var scope = new int[n + 1][2];
//        for (int i = 0; i <= n; i++) {
//            scope[i] = new int[]{Math.max(i - ranges[i], 0), Math.min(i + ranges[i], n)};
//        }
//        Arrays.sort(scope, Comparator.comparingInt(o -> o[0]));
//        var dp = new int[n + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for (int i = 0; i <= n; i++) {
//            int start = scope[i][0], end = scope[i][1];
//            if (dp[start] == Integer.MAX_VALUE) {
//                return -1;
//            }
//            for (int j = start; j <= end; j++) {
//                dp[j] = Math.min(dp[j], dp[start] + 1);
//            }
//        }
//        return dp[n];
    }

    public static int dfs(int n, int[] ranges, int index, int[] onOff, int left, int right, int [][][] cache) {
        if (left <= 0 && right >= n) {
            return Arrays.stream(onOff).sum();
        }
        if (index > n) {
            return -1;
        }
        if (cache[index][left][right] != 0) {
            return cache[index][left][right];
        }
        //off
        int off = dfs(n, ranges, index + 1, onOff, left, right, cache);
        //on
        if (index - ranges[index] > right || ranges[index] == 0) {
            return off;
        }
        onOff[index] = 1;
        left = Math.min(left, index - ranges[index]);
        if (left < 0) {
            left = 0;
        }
        right = Math.max(right, index + ranges[index]);
        if (right > n) {
            right = n;
        }
        int on = dfs(n, ranges, index + 1, onOff, left, right, cache);
        onOff[index] = 0;
        if (off == -1) {
            cache[index][left][right] = on;
            return on;
        } else if (on == -1) {
            cache[index][left][right] = off;
            return off;
        } else {
            cache[index][left][right] =  Math.min(on, off);
            return cache[index][left][right];
        }
    }

//    public static int minTaps(int n, int[] ranges) {
//
//        var scope = new int[n + 1][2];
//        var garden = new int[n + 1];
//        var queue = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[0] - o[1]));
//        for (int i = 0; i <= n; i++) {
//            if (ranges[i] != 0) {
//                scope[i] = new int[]{i - ranges[i] >= 0 ? i - ranges[i] : 0, i + ranges[i]};
//                queue.add(scope[i]);
//            }
//        }
//
//        int count = 0;
//        int res = 0;
//
//        while (!queue.isEmpty()) {
//            int[] poll = queue.poll();
//            for (int i = poll[0]; i <= n && i <= poll[1]; i++) {
//                if (garden[i] == 0) {
//                    count++;
//                    garden[i] = 1;
//                }
//            }
//            ++res;
//            if (count == n + 1) {
//                break;
//            }
//        }
//
//        return count == n + 1 ? res : -1;
//    }
}
