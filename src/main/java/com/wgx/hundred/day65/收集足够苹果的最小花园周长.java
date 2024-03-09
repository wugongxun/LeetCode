package com.wgx.hundred.day65;

/**
 * @author wgx
 * @since 2023/12/24 13:53
 */
public class 收集足够苹果的最小花园周长 {

    public static void main(String[] args) {
        System.out.println(minimumPerimeter(1));
    }

    public static long minimumPerimeter(long neededApples) {
        long l = 1, r = 100000, res = 0;
        while (l <= r) {
            long mid = (r + l) / 2;
            if (2 * mid * (mid + 1) * (2 * mid + 1) >= neededApples) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res * 8;
    }
}
