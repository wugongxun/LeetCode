package com.wgx.周赛.第352场周赛;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/7/2 10:58
 */
public class 和等于目标值的质数对 {
    @Test
    public void test() {
        System.out.println(findPrimePairs(10));
//        System.out.println(findPrimePairs(3));
    }

    private static final int MAX = 1000000;
    private static final boolean[] isPrime = new boolean[MAX + 1];
    private static List<Integer> primes;

    //线性筛（欧拉筛）
    static {
        primes = new ArrayList<>();
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (var prime : primes) {
                if (prime * i >= MAX) {
                    break;
                }
                isPrime[prime * i] = false;
                if (i % prime == 0) {
                    break;
                }
            }
        }
    }


//    埃氏筛
//    static {
//        primes = new ArrayList<>();
//        for (int i = 2; i <= MAX; i++) {
//            isPrime[i] = true;
//        }
//        for (int i = 2; i <= MAX; i++) {
//            if (isPrime[i]) {
//                primes.add(i);
//                for (int j = i; j <= MAX / i; ++j) {
//                    isPrime[i * j] = false;
//                }
//            }
//        }
//    }

    public List<List<Integer>> findPrimePairs(int n) {
        var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < primes.size(); i++) {
            int x = primes.get(i);
            int y = n - x;
            if (y < x) {
                break;
            }
            if (isPrime[y]) {
                var list = new ArrayList<Integer>();
                list.add(x);
                list.add(y);
                res.add(list);
            }
        }
        return res;
    }
}
