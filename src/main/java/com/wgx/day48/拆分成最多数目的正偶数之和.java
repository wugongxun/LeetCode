package com.wgx.day48;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/7/6 16:51
 */
public class 拆分成最多数目的正偶数之和 {
    public static void main(String[] args) {
        System.out.println(maximumEvenSplit(10000));
    }


    public static List<Long> maximumEvenSplit(long finalSum) {
        if ((finalSum & 1) == 1) {
            return new ArrayList<>();
        }
        List<Long> res = new ArrayList<>();
        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
        return res;
    }
}
