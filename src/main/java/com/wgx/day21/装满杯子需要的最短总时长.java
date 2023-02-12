package com.wgx.day21;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/2/11 15:12
 */
public class 装满杯子需要的最短总时长 {
    public static void main(String[] args) {
        System.out.println(fillCups(new int[]{4, 7, 9}));
    }

    public static int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[0] + amount[1] <= amount[2]) {
            return amount[2];
        } else {
            return (amount[0] + amount[1] + amount[2] + 1) / 2;
        }
    }
}
