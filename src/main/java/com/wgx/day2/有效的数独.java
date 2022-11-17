package com.wgx.day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/27 17:25
 */
public class 有效的数独 {
    public static void main(String[] args) {
        String[][] board = {
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        };
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(String[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grids = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                String val = board[i][j];
                if (val.equals(".")) continue;
                int intVal = Integer.parseInt(val) - 1;
                int grid = (i / 3) * 3 + j / 3;
                if (rows[i][intVal] || cols[j][intVal] || grids[grid][intVal])
                    return false;
                rows[i][intVal] = cols[j][intVal] = grids[grid][intVal] = true;
            }
        }
        return true;
    }
}
