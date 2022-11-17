package com.wgx.day6;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/12 9:38
 */
public class 位1的个数 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(-3 >>> 2));
        System.out.println(-3 >>> 2);

    }

    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
        }
        return count;
    }
}
