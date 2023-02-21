package com.wgx.day24;

/**
 * @author wgx
 * @since 2023/2/20 10:57
 */
public class 零钱兑换 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        var dp = new int[amount][coins.length];
        return 0;
    }
}
