package com.wgx.day19;

/**
 * @author wgx
 * @since 2023/1/31 17:02
 */
public class 判断矩阵是否是一个X矩阵 {
    public static void main(String[] args) {
        System.out.println(checkXMatrix(new int[][]{
                {5,0,20},
                {0,5,0},
                {6,0,2}
        }));
    }

    public static boolean checkXMatrix(int[][] grid) {
        int i = 0, j = grid.length - 1;
        int gap = 1;
        boolean flag = grid.length % 2 == 0;
        for (int[] row : grid) {
            for (int k = 0; k < grid.length; k++) {
                if (k == i || k == j) {
                    if (row[k] == 0) {
                        return false;
                    }
                } else if (row[k] != 0) {
                    return false;
                }
            }
            if (j - i <= 1 && flag) {
                gap = -gap;
                flag = false;
                continue;
            }
            i += gap;
            j -= gap;
        }
        return true;
    }
}
