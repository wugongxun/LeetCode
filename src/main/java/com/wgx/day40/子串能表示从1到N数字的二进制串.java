package com.wgx.day40;

import java.util.HashSet;

/**
 * @author wgx
 * @since 2023/5/11 10:04
 */
public class 子串能表示从1到N数字的二进制串 {
    public static void main(String[] args) {
        System.out.println(queryString("0110100100110010110101011001101100111101", 20));
    }

    /**
     *  例：
     *      如果需要从一个区间中截取出4个长度为3的子区间，则这个区间的长度最小为(3 + (4 - 1)) = 6
     *
     *  设n的二进制长度为k + 1（方便计算）
     *  设s的长度为m
     *      - 区间[2 ^ k, n]内的所有数的二进制数的长度都为k + 1，共有n - 2 ^ k + 1个数
     *        所以需要m >= (k + 1) + (n - 2 ^ k + 1 - 1) = k + 1 + n - 2 ^ k
     *      - 区间[2 ^ (k - 1), 2 ^ k - 1]内所有的数的二进制数的长度都为k，共有2 ^ (k - 1)个数
     *        所以需要m >= k + 2 ^ (k - 1) - 1
     *      - 而小于[2 ^ (k - 1), 2 ^ k - 1]的区间则可以通过区间[2 ^ (k - 1), 2 ^ k - 1]整体向右移动得到
     *        因此如果s中包含[2 ^ (k - 1), 2 ^ k - 1]中的所有数，则小于2 ^ (k - 1)的数也存在
     */
    public static boolean queryString(String s, int n) {
        if (n == 1) {
            return s.contains("1");
        }
        int k = 31 - Integer.numberOfLeadingZeros(n);
        if (s.length() < Math.max(k + 1 + n - (1 << k), k + 1 << (k - 1) - 1)) {
            return false;
        }
        //check(s, k + 1, 1 << k, n)    判断区间[2 ^ k, n]内的数是否都存在
        //check(s, k, n / 2 + 1, (1 << k) - 1)      判断区间[2 ^ (k - 1), 2 ^ k - 1]内的数是否都存在
        //      因为区间[2 ^ (k - 1), n / 2]可以有区间[2 ^ k, n]整体向右移动一位得到，所以只需要判断区间[n / 2 + 1, 2 ^ k - 1]
        return check(s, k + 1, 1 << k, n) && check(s, k, n / 2 + 1, (1 << k) - 1);
    }

    public static boolean check(String s,int k, int lower, int upper) {
        if (lower > upper) {
            return true;
        }
        var set = new HashSet<Integer>();
        int mask = (1 << (k - 1)) - 1;
        int x = Integer.parseInt(s.substring(0, k - 1), 2);
        int m = s.length();
        for (int i = k - 1; i < m; ++i) {
            x = ((x & mask) << 1) | (s.charAt(i) - '0');
            if (x >= lower && x <= upper) {
                set.add(x);
            }
        }
        return set.size() == upper - lower + 1;
    }

//    public static boolean queryString(String s, int n) {
//        var set = new HashSet<Integer>();
//        int len = s.length();
//        for (int i = 0; i < len; ++i) {
//            int t = s.charAt(i) - '0';
//            if (t == 0) {
//                continue;
//            }
//            for (int j = i + 1; t <= n; ++j) {
//                set.add(t);
//                if (j == len) {
//                    break;
//                }
//                t = (t << 1) | (s.charAt(j) - '0');
//            }
//        }
//
//        return set.size() == n;
//    }


}
