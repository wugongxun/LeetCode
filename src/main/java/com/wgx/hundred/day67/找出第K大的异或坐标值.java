package com.wgx.hundred.day67;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2024/5/26 11:58
 */
public class 找出第K大的异或坐标值 {

    public static void main(String[] args) {
//        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));
//        System.out.println(kthLargestValue(new int[][]{{8, 10, 5, 8, 5, 7, 6, 0, 1, 4, 10, 6, 4, 3, 6, 8, 7, 9, 4, 2}}, 2));
        System.out.println(kthLargestValue(new int[][]{{10, 9, 5}, {2, 0, 4}, {1, 0, 9}, {3, 4, 8}}, 10));
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        var res = new int[n * m];
        int index = 0;
        var XOR = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                XOR[i + 1][j + 1] = XOR[i][j] ^ XOR[i + 1][j] ^ XOR[i][j + 1] ^ matrix[i][j];
                res[index++] = XOR[i + 1][j + 1];
            }
        }
        Arrays.sort(res);
        return res[index - k];
    }

}