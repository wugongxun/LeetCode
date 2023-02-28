package com.wgx.day25;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/2/23 10:07
 */
public class 循环码排列 {
    public static void main(String[] args) {
        System.out.println(circularPermutation(2, 3));
    }

    public static List<Integer> circularPermutation(int n, int start) {
        var res = new ArrayList<Integer>(1 << n);
        for (int i = 0; i < 1 << n; ++i) {
            res.add(i >> 1 ^ i ^ start);
        }
        return res;
    }
}