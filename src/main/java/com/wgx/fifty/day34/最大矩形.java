package com.wgx.fifty.day34;

/**
 * @author wgx
 * @since 2023/4/13 10:16
 */
public class 最大矩形 {
    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }


//    使用柱状图的优化暴力方法
    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        var left = new int[row][col];
        for (int i = 0; i < row; i++) {
            int len = 0;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = ++len;
                } else {
                    len = 0;
                }
            }
        }


        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int width = left[i][j];
                    int area = width;
                    for (int k = i - 1; k >= 0; k--) {
                        if (left[k][j] == 0) {
                            break;
                        }
                        width = Math.min(width, left[k][j]);
                        area = Math.max(area, width * (i - k + 1));
                    }
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }


//    暴力bfs
//    static int row, col;
//    static char[][] matrix;
//
//    public static int maximalRectangle(char[][] matrix) {
//        最大矩形.row = matrix.length;
//        最大矩形.col = matrix[0].length;
//        最大矩形.matrix = matrix;
//        int res = 0;
//        for (int i = 0; i < row; ++i) {
//            for (int j = 0; j < col; ++j) {
//                if (matrix[i][j] == '1') {
//                    res = Math.max(res, bfs(i, j));
//                }
//            }
//        }
//        return res;
//    }
//
//    public static int bfs(int i, int j) {
//        int res = 1;
//        int maxCol = Integer.MAX_VALUE;
//        for (int k = 0; k + i < row; ++k) {
//            for (int l = 0; l + j < col; ++l) {
//                if (matrix[k + i][l + j] == '0' || l + j == col - 1) {
//                    if (l == 0 && matrix[k + i][l + j] == '0') {
//                        return res;
//                    }
//                    int curCol = matrix[k + i][l + j] == '0' ? l : l + 1;
//                    maxCol = Math.min(maxCol, curCol);
//                    res = Math.max(res, maxCol * (k + 1));
//                    break;
//                }
//            }
//        }
//        return res;
//    }
}
