package com.wgx.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/7 17:25
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
    static List<Integer> cache = new ArrayList<>();
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        cache.add(1);
        cache.add(2);
        int temp = 3;
        while (temp < n) {
            cache.add(cache.get(temp - 2) + cache.get(temp - 3));
            temp++;
        }
        return cache.get(n - 2) + cache.get(n - 3);
    }
}
