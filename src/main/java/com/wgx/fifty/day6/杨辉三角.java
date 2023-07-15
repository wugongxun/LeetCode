package com.wgx.fifty.day6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/12 9:54
 */
public class 杨辉三角 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        list.add(row);
        if (numRows == 1) {
            return list;
        }
        generate(numRows, 2, list);
        return list;
    }

    public static void generate(int numRows, int cur, List<List<Integer>> list) {
        if (cur > numRows)
            return;
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < cur; i++) {
            if (i == 0 || i == cur - 1)
                row.add(1);
            else {
                List<Integer> prevRow = list.get(cur - 2);
                row.add(prevRow.get(i - 1) + prevRow.get(i));
            }
        }
        list.add(cur - 1, row);
        generate(numRows, cur + 1, list);
    }
}
