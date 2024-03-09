package com.wgx.hundred.day65;

import java.util.List;

/**
 * @author wgx
 * @since 2024/1/27 10:48
 */
public class 最大合金数 {
    public static void main(String[] args) {
//        var composition = List.of(List.of(1, 1, 1), List.of(1, 1, 10));
//        System.out.println(maxNumberOfAlloys(3, 2, 15, composition, List.of(0, 0, 100), List.of(1, 2, 3)));
//        var composition = List.of(List.of(2, 1), List.of(1, 2), List.of(1, 1));
//        System.out.println(maxNumberOfAlloys(2, 3, 10, composition, List.of(1, 1), List.of(5, 5)));
//        var composition = List.of(List.of(10, 10, 1, 5), List.of(9, 7, 7, 1), List.of(6, 3, 5, 9), List.of(2, 10, 2, 7));
//        System.out.println(maxNumberOfAlloys(4, 4, 17, composition, List.of(9, 8, 2, 7), List.of(9, 2, 6, 10)));
//        var composition = List.of(List.of(6, 3), List.of(9, 5), List.of(1, 9), List.of(1, 8), List.of(3, 3));
//        System.out.println(maxNumberOfAlloys(2, 5, 48, composition, List.of(4, 8), List.of(10, 1)));
        var composition = List.of(List.of(4));
        System.out.println(maxNumberOfAlloys(1, 8, 69, composition, List.of(10), List.of(9)));
    }

    public static int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long res = 0;
        for (var machine : composition) {
            long max = 0;
            int oneCost = 0;
            for (int j = 0; j < n; ++j) {
                var v = stock.get(j);
                max += (long) v * cost.get(j);
                oneCost += machine.get(j) * cost.get(j);
            }
            long l = 0, r = (max + budget) / oneCost;
            while (l <= r) {
                long mid = (l + r) / 2;
                long realCost = 0;
                for (int j = 0; j < n; j++) {
                    if (stock.get(j) < mid * machine.get(j)) {
                        realCost += (mid * machine.get(j) - stock.get(j)) * cost.get(j);
                    }
                }
                if (realCost > budget) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            res = Math.max(res, r);
        }
        return (int) res;
    }
}
