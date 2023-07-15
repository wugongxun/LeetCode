package com.wgx.fifty.day38;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/4/30 20:35
 */
public class 移动石子直到连续 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numMovesStones(1, 4, 3)));
    }

    public static int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(Math.min(a, b), c);
        int z = Math.max(Math.max(a, b), c);
        int y = a + b + c - x - z;
        int min = 0;
        if (z - y == 1 && y - x == 1) {
            min = 0;
        } else if (z - y <= 2 || y - x <= 2) {
            min = 1;
        } else {
            min = 2;
        }
        int max = z - x - 2;

        return new int[]{min, max};
    }
}
