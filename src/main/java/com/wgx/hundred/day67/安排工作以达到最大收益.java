package com.wgx.hundred.day67;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wgx
 * @since 2024/5/19 15:33
 */
public class 安排工作以达到最大收益 {

    public static void main(String[] args) {

    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        var ids = new Integer[n];
        for (int i = 0; i < n; ++i) {
            ids[i] = i;
        }
        Arrays.sort(ids, Comparator.comparingInt(i -> difficulty[i]));
        Arrays.sort(worker);
        int res = 0, i = 0, best = 0;
        for (var w : worker) {
            while (i < n && w >= difficulty[ids[i]]) {
                best = Math.max(best, profit[ids[i]]);
                i++;
            }
            res += best;
        }
        return res;
    }

}
