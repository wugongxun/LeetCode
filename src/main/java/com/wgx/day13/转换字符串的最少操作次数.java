package com.wgx.day13;

/**
 * @author wgx
 * @since 2022/12/27 10:01
 * 给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
 *
 * 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。注意，如果字符已经是 'O' ，只需要保持 不变 。
 *
 * 返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
 */
public class 转换字符串的最少操作次数 {
    public static void main(String[] args) {
        System.out.println(minimumMoves("OOOO"));
    }

    public static int minimumMoves(String s) {
        int index = s.indexOf("X");
        int lastIndex = s.lastIndexOf("X");
        if (index == -1) {
            return 0;
        }
        int count = 0;
        for (int i = index; i <= lastIndex; i++) {
            if (s.charAt(i) == 'X') {
                i += 2;
                count++;
            }
        }
        return count;
    }
}
