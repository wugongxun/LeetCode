package com.wgx.周赛.第344场周赛;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/5/7 11:12
 */
public class 有相同颜色的相邻元素数目 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(colorTheArray(4, new int[][]{
                {0, 2}, {1, 2}, {3, 1}, {1, 1}, {2, 1}
        })));
    }

    public static int[] colorTheArray(int n, int[][] queries) {
        int m = queries.length;
        var colors = new int[n + 2];
        int sum = 0;
        var res = new int[m];
        for (int i = 0; i < m; ++i) {
            var index = queries[i][0];
            var color = queries[i][1];
            int temp = 0;
            if (color == colors[index + 1]) {
                res[i] = sum;
                continue;
            }
            if (colors[index + 1] != 0) {
                if (colors[index] == colors[index + 1]) {
                    temp--;
                }
                if (colors[index + 1] == colors[index + 2]) {
                    temp--;
                }
            }
            colors[index + 1] = color;
            if (colors[index] == colors[index + 1]) {
                temp++;
            }
            if (colors[index + 1] == colors[index + 2]) {
                temp++;
            }
            sum += temp;
            res[i] = sum;
        }
        return res;
    }
}
