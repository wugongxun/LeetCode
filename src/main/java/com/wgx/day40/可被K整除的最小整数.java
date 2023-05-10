package com.wgx.day40;

import java.util.HashSet;

/**
 * @author wgx
 * @since 2023/5/10 9:41
 */
public class 可被K整除的最小整数 {
    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(177));
    }

    public static int smallestRepunitDivByK(int k) {
        var set = new HashSet<Integer>();
        /**
         * 有
         * (a + b) % m = ((a % m) + (b % m)) % m
         * (a * b) % m = ((a % m) * (b % m)) % m
         * 设
         * t % k = x
         * 则
         * (t * 10 + 1) % k = ((t * 10) % k + 1 % k) % k
         *                  = (((t % k) * (10 % k)) % k + 1 % k) % k
         *                  = ((x * (10 % k)) % k + 1 % k) % k
         *                  = (((x % k) * (10 % k % k)) % k + 1 % k) % k
         *                  = (((x % k) * (10 % k)) % k + 1 % k) % k
         *                  = ((x * 10) % k + 1 % k) % k
         *                  = (x * 10 + 1) % k
         */
        int x = 1 % k;
        while (x > 0 && set.add(x)) {
            x = (x * 10 + 1) % k;
        }
        return x > 0 ? -1 : set.size() + 1;
    }
}
