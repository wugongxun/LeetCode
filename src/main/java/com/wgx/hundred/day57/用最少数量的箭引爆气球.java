package com.wgx.hundred.day57;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wgx
 * @since 2023/7/29 21:32
 */
public class 用最少数量的箭引爆气球 {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        }));
    }

    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(i -> i[1]));
        int end = points[0][1];
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (points[i][0] > end) {
                res++;
                end = points[i][1];
            }
        }
        return res;
    }
}
