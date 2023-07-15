package com.wgx.fifty.day45;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/6/21 13:59
 */
public class 黑白翻转棋 {
    @Test
    public void test() {
        System.out.println(flipChess(new String[]{".X.", ".O.", "XO."}));
    }

    int n, m;
    char[][] board;
    int[][] dirs;

    public int flipChess(String[] chessboard) {
        n = chessboard.length;
        m = chessboard[0].length();
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = chessboard[i].toCharArray();
        }
        dirs = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}
        };
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == '.') {
                    res = Math.max(res, bfs(i, j));
                }
            }
        }

        return res;
    }

    public int bfs(int i, int j) {
        var board = new char[n][m];
        for (int k = 0; k < n; k++) {
            board[k] = Arrays.copyOf(this.board[k], m);
        }

        int count = 0;
        var queue = new ArrayDeque<int[]>();
        queue.offerLast(new int[]{i, j});
        board[i][j] = 'X';
        while (!queue.isEmpty()) {
            var t = queue.pollFirst();
            for (var dir : dirs) {
                if (check(board, t[0], t[1], dir[0], dir[1])) {
                    int x = t[0] + dir[0];
                    int y = t[1] + dir[1];
                    while (board[x][y] != 'X') {
                        queue.offerLast(new int[]{x, y});
                        board[x][y] = 'X';
                        x += dir[0];
                        y += dir[1];
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean check(char[][] board, int i, int j, int di, int dj) {
        i += di;
        j += dj;
        while (i >= 0 && i < n && j >= 0 && j < m)  {
            if (board[i][j] == 'X') {
                return true;
            } else if (board[i][j] == '.') {
                return false;
            }
            i += di;
            j += dj;
        }
        return false;
    }
}
