package com.wgx.fifty.day19;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/2/4 13:29
 *
 * 给你一个长度为 n 的整数数组 coins ，它代表你拥有的 n 个硬币。第 i 个硬币的值为 coins[i] 。如果你从这些硬币中选出一部分硬币，它们的和为 x ，那么称，你可以 构造 出 x 。
 *
 * 请返回从 0 开始（包括 0 ），你最多能 构造 出多少个连续整数。
 *
 * 你可能有多个相同值的硬币。
 */
public class 你能构造出连续值的最大数目 {
    public static void main(String[] args) {
        System.out.println(getMaximumConsecutive(new int[]{1,3,4}));
    }

    public static int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > res) {
                break;
            } else {
                res += coin;
            }
        }
        return res;
    }
}
