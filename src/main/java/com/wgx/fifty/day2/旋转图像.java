package com.wgx.fifty.day2;

import java.util.Arrays;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/28 9:45
 */
public class 旋转图像 {
    public static void main(String[] args) {
        //[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        rotate(matrix, 0);
        System.out.print("[");
        for (int[] rows : matrix) {
            System.out.print(Arrays.toString(rows));
        }
        System.out.print("]");
    }
    public static void rotate(int[][] matrix, int n) {
        int len = matrix.length - 1;
        //先保存左上角的数
        int temp  = matrix[n][n];
        //依次旋转边角
        matrix[n][n] = matrix[len - n][n];
        matrix[len - n][n] = matrix[len - n][len - n];
        matrix[len - n][len - n] = matrix[n][len - n];
        matrix[n][len - n] = temp;
        //移动边
        for (int i = n + 1, j = 0; i < len - n; i++, j++) {
            temp = matrix[n][i];
            matrix[n][i] = matrix[len - i][n];
            matrix[len - i][n] = matrix[len - n][len - i];
            matrix[len - n][len - i] = matrix[i][len - n];
            matrix[i][len - n] = temp;
        }
        if (++n < matrix.length / 2) {
            rotate(matrix, n);
        }
    }
}
