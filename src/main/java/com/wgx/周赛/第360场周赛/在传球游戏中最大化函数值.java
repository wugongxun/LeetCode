package com.wgx.周赛.第360场周赛;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/8/27 11:07
 */
public class 在传球游戏中最大化函数值 {
    @Test
    public void test() {
        var receiver = new ArrayList<Integer>();
        receiver.add(1);
        receiver.add(0);
//        receiver.add(1);
//        receiver.add(2);
//        receiver.add(3);
        System.out.println(getMaxFunctionValue(receiver, 10000000000L));
    }

    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int n = receiver.size();
        int max = 64 - Long.numberOfLeadingZeros(k);
        var pa = new int[n][max];
        var vals = new long[n][max];
        for (int i = 0; i < n; i++) {
            pa[i][0] = receiver.get(i);
            vals[i][0] = receiver.get(i);
        }
        for (int i = 0; i < max - 1; i++) {
            for (int j = 0; j < n; j++) {
                int p = pa[j][i];
                long v = vals[j][i];
                pa[j][i + 1] = pa[p][i];
                vals[j][i + 1] = vals[p][i] + v;
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            long sum = i;
            int x = i;
            for (int j = 0; j <= max; j++) {
                if ((k >> j & 1) == 1) {
                    sum += vals[x][j];
                    x = pa[x][j];
                }
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
