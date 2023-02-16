package com.wgx.day23;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/2/16 10:00
 */
public class 搜索二维矩阵II {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {-1},
                {-1}
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
        }, 0));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(matrix[i], target) >= 0) {
                return true;
            }
            if (binarySearch(matrix, target, i, matrix.length - 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[][] matrix, int target, int start, int end) {
        int mid;
        int i = start;
        while (start <= end) {
            mid = (start + end) / 2;
            if (matrix[mid][i] == target) {
                return true;
            }
            if (matrix[mid][i] > target) {
                end = mid - 1;
            }
            if (matrix[mid][i] < target) {
                start = mid + 1;
            }
        }
        return false;
    }
}
