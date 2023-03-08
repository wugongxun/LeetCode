package com.wgx.day27;

import java.util.HashSet;

/**
 * @author wgx
 * @since 2023/3/8 10:11
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */
public class 快乐数 {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        var set = new HashSet<Integer>();
        while (n != 1) {
            String s = String.valueOf(n);
            n = 0;
            for (int i = 0; i < s.length(); i++) {
                int d = Integer.parseInt(s.charAt(i) + "");
                n += d * d;
            }
            if (!set.add(n)) {
                return false;
            }
        }
        return true;
    }
}
