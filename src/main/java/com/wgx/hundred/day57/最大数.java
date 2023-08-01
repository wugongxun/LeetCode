package com.wgx.hundred.day57;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/7/29 13:51
 */
public class 最大数 {
    public static void main(String[] args) {
//        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
//        System.out.println(largestNumber(new int[]{432, 43243}));
        System.out.println(largestNumber(new int[]{999999991, 9}));
    }

    public static String largestNumber(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf).sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2)).reduce((res, i) -> res + (i.equals("0") && res.equals("0") ? "" : i)).get();
    }
}
