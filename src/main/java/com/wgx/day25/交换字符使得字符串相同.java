package com.wgx.day25;

/**
 * @author wgx
 * @since 2023/2/25 18:55
 */
public class 交换字符使得字符串相同 {
    public static void main(String[] args) {
        System.out.println(minimumSwap("xx", "yy"));
    }

    public static int minimumSwap(String s1, String s2) {
        int xyCount = 0, yxCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xyCount++;
            }
            if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yxCount++;
            }
        }
        if ((xyCount + yxCount) % 2 == 1) {
            return -1;
        }
        int res = 0;
        res = (xyCount + 1) / 2 + (yxCount + 1) / 2;
        return res;
    }
}
