package com.wgx.fifty.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wgx
 * @since 2023/2/9 15:11
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class 合并区间 {
    public static void main(String[] args) {
        System.out.println(merge(new int[][]{
                {1 ,3},
                {2, 6},
                {8, 10},
                {15, 18}
        }));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));
        int start0 = intervals[0][0], end0 = intervals[0][1];
        var res = new ArrayList<int[]>();
        for (int i = 1; i < intervals.length; i++) {
            int start1 = intervals[i][0], end1 = intervals[i][1];
            if (start1 <= end0) {
                end0 = Math.max(end1, end0);
            } else {
                res.add(new int[]{start0, end0});
                start0 = start1;
                end0 = end1;
            }
        }
        res.add(new int[]{start0, end0});
        return res.toArray(int[][]::new);
    }
}
