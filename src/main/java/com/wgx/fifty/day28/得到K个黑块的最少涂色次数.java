package com.wgx.fifty.day28;

/**
 * @author wgx
 * @since 2023/3/9 9:51
 */
public class 得到K个黑块的最少涂色次数 {
    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
    }

    public static int minimumRecolors(String blocks, int k) {
        int res = 0;
        for (int i = 0; i < k; ++i) {
            if (blocks.charAt(i) == 'B') {
                ++res;
            }
        }

        int temp = res;
        for (int j = 0, i = k; i < blocks.length(); ++j, ++i) {
            if (blocks.charAt(j) == 'B') {
                --temp;
            }
            if (blocks.charAt(i) == 'B') {
                ++temp;
            }
            res = Math.max(temp, res);
        }
        return k - res;
    }
}
