package com.wgx.day29;

/**
 * @author wgx
 * @since 2023/3/14 9:35
 */
public class 给定行和列的和求可行矩阵 {
    public static void main(String[] args) {
        restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8});
    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        var rows = rowSum.length;
        var cols = colSum.length;
        var res = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (colSum[i] == 0)
                    break;
                if (rowSum[j] == 0)
                    continue;
                int min = Math.min(colSum[i], rowSum[j]);
                colSum[i] -= min;
                rowSum[j] -= min;
                res[j][i] = min;
            }
        }
        return res;
    }
}
