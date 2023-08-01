package com.wgx.hundred.day57;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wgx
 * @since 2023/7/29 19:22
 */
public class 无重叠区间 {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        }));
    }

    //dp
    public static int eraseOverlapIntervals(int[][] intervals) {
        //O (n ^ 2)
//        int n = intervals.length;
//        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
//        var dp = new int[n];
//        Arrays.fill(dp, 1);
//        for (int i = 1; i < n; ++i) {
//            for (int j = 0; j < i; ++j) {
//                if (intervals[j][1] <= intervals[i][0]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        return n - Arrays.stream(dp).max().getAsInt();

        //优化
        //O (n * log n)
//        int n = intervals.length;
//        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
//        int len = 1;
//        var d = new int[n + 1];
//        d[len] = intervals[0][1];
//        for (int i = 1; i < n; i++) {
//            int start = intervals[i][0];
//            int end = intervals[i][1];
//            if (start >= d[len]) {
//                d[++len] = end;
//            } else {
//                int l = 1, r = len, pos = 0;
//                while (l <= r) {
//                    int mid = (l + r) >> 1;
//                    if (d[mid] > end) {
//                        r = mid - 1;
//                        pos = mid;
//                    } else {
//                        l = mid + 1;
//                    }
//                }
//                d[pos] = end;
//            }
//        }
//        return n - len;

        //优化空间
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int len = 0;
        for (int i = 1; i < n; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= intervals[len][1]) {
                len++;
                intervals[len][0] = start;
                intervals[len][1] = end;
            } else {
                int l = 0, r = len, pos = -1;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (intervals[mid][1] > end) {
                        pos = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                if (pos != -1)
                    intervals[pos][1] = end;
            }
        }
        return n - len - 1;
    }

    //贪心
//    public static int eraseOverlapIntervals(int[][] intervals) {
//        int n = intervals.length;
//        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
//        int end = intervals[0][1];
//        int res = 0;
//        for (int i = 1; i < n; ++i) {
//            if (intervals[i][0] < end) {
//                res++;
//            } else {
//                end = intervals[i][1];
//            }
//        }
//        return res;
//    }
}
