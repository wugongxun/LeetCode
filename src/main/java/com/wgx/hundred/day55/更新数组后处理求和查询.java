package com.wgx.hundred.day55;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/7/26 9:31
 * <p>
 * 给你两个下标从 0 开始的数组 nums1 和 nums2 ，和一个二维数组 queries 表示一些操作。总共有 3 种类型的操作：
 * 操作类型 1 为 queries[i] = [1, l, r] 。你需要将 nums1 从下标 l 到下标 r 的所有 0 反转成 1 或将 1 反转成 0 。l 和 r 下标都从 0 开始。
 * 操作类型 2 为 queries[i] = [2, p, 0] 。对于 0 <= i < n 中的所有下标，令 nums2[i] = nums2[i] + nums1[i] * p 。
 * 操作类型 3 为 queries[i] = [3, 0, 0] 。求 nums2 中所有元素的和。
 * 请你返回一个数组，包含所有第三种操作类型的答案。
 */
public class 更新数组后处理求和查询 {
    @Test
    public void test() {
        System.out.println(Arrays.toString(handleQuery(new int[]{1, 0, 1}, new int[]{0, 0, 0}, new int[][]{
                {1, 1, 1}, {2, 1, 0}, {3, 0, 0}
        })));
    }

    int[] cnt1;
    boolean[] flip;

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        cnt1 = new int[4 * n];
        flip = new boolean[4 * n];
        build(nums1, 1, 1, n);
        long sum = 0;
        for (int num : nums2) {
            sum += num;
        }
        int m = 0;
        for (var query : queries)
            if (query[0] == 3)
                ++m;
        var res = new long[m];
        int i = 0;
        for (var query : queries) {
            switch (query[0]) {
                case 1 -> update(1, 1, n, query[1] + 1, query[2] + 1);
                case 2 -> sum += (long) query[1] * cnt1[1];
                case 3 -> res[i++] = sum;
            }
        }
        return res;
    }

    public void maintain(int o) {
        cnt1[o] = cnt1[2 * o] + cnt1[2 * o + 1];
    }

    public void do_(int o, int l, int r) {
        cnt1[o] = r - l + 1 - cnt1[o];
        flip[o] = !flip[o];
    }

    public void build(int[] arr, int o, int l, int r) {
        if (l == r) {
            cnt1[o] = arr[l - 1];
            return;
        }
        int m = (l + r) / 2;
        build(arr, o * 2, l, m);
        build(arr, o * 2 + 1, m + 1, r);
        maintain(o);
    }

    public void update(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            do_(o, l, r);
            return;
        }
        int m = (l + r)  / 2;
        if (flip[o]) {
            do_(o * 2, l, m);
            do_(o * 2 + 1, m + 1, r);
            flip[o] = false;
        }
        if (m >= L)
            update(o * 2, l, m, L, R);
        if (m < R)
            update(o * 2 + 1, m + 1, r, L, R);
        maintain(o);
    }


//    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
//        var list = new ArrayList<Long>();
//        long[] longNums2 = Arrays.stream(nums2).mapToLong(Long::valueOf).toArray();
//        for (var query : queries) {
//            switch (query[0]) {
//                case 1 -> ops1(nums1, query[1], query[2]);
//                case 2 -> ops2(nums1, longNums2, query[1]);
//                case 3 -> list.add(ops3(longNums2));
//            }
//        }
//        return list.stream().mapToLong(i -> i).toArray();
//    }
//
//    public void ops1(int[] nums1, int l, int r) {
//        for (int i = l; i <= r; i++) {
//            nums1[i] ^= 1;
//        }
//    }
//
//    public void ops2(int[] nums1, long[] nums2, long p) {
//        for (int i = 0; i < nums2.length; i++) {
//            nums2[i] += nums1[i] * p;
//        }
//    }
//
//    public long ops3(long[] nums2) {
//        long res = 0;
//        for (int i = 0; i < nums2.length; i++) {
//            res += nums2[i];
//        }
//        return res;
//    }
}
