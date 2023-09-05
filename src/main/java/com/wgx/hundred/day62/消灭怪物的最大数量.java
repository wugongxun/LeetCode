package com.wgx.hundred.day62;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/9/3 17:33
 */
public class 消灭怪物的最大数量 {
    public static void main(String[] args) {
        System.out.println(eliminateMaximum(new int[]{3, 2, 4}, new int[]{5, 3, 2}));
//        System.out.println(eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        var time = new int[n];
        for (int i = 0; i < n; i++)
            time[i] = (dist[i] - 1) / speed[i] + 1;
        Arrays.sort(time);
        for (int i = 0; i < n; i++)
            if (time[i] <= i)
                return i;
        return n;
    }
}
