package com.wgx.fifty.day18;

/**
 * @author wgx
 * @since 2023/1/26 21:34
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class 单词搜索 {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        }, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0)
            return false;
        char ch = word.charAt(index);
        if (ch != board[i][j])
            return false;
        if (index == word.length() - 1)
            return true;
        char temp = board[i][j];
        board[i][j] = '.';
        boolean res = dfs(board, word, index + 1, i - 1, j)
                || dfs(board, word, index + 1, i, j + 1)
                || dfs(board, word, index + 1, i + 1, j)
                || dfs(board, word, index + 1, i, j - 1);
        board[i][j] = temp;
        return res;
    }
}
