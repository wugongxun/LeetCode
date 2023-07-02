package com.wgx.day47;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/6/30 10:02
 */
public class N皇后 {
    @Test
    public void test() {
        System.out.println(solveNQueens(4));
    }

    int n;
    List<List<String>> res;
    List<String> list;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(0);
        return res;
    }

    public void dfs(int i) {
        if (i == n) {
            res.add(new ArrayList<>(list));
        }
        for (int j = 0; j < n; ++j) {
            if (valid(i, j)) {
                String s = ".".repeat(j) + "Q" + ".".repeat(n - j - 1);
                list.add(s);
                dfs(i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean valid(int i, int j) {
        //向上
        for (int k = i - 1; k >= 0; --k) {
            if (list.get(k).charAt(j) == 'Q') {
                return false;
            }
        }

        //向左上
        for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--) {
            if (list.get(k).charAt(l) == 'Q') {
                return false;
            }
        }

        //向右上
        for (int k = i - 1, l = j + 1; k >= 0 && l < n; k--, l++) {
            if (list.get(k).charAt(l) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
