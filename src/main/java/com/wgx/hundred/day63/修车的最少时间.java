package com.wgx.hundred.day63;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/9/7 14:34
 */
public class 修车的最少时间 {
    @Test
    public void test() {
        System.out.println(repairCars(new int[]{4, 2, 3, 1}, 986873));
    }

    public long repairCars(int[] ranks, int cars) {
        long lower = 0, upper = (long) ranks[0] * cars * cars;
        while (lower < upper) {
            long mid = lower + upper >> 1;
            if (calculate(ranks, mid) >= cars) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }

    public long calculate(int[] ranks, long time) {
        long res = 0;
        for (var rank : ranks) {
            res += (long) Math.sqrt(time / rank);
        }
        return res;
    }
}
