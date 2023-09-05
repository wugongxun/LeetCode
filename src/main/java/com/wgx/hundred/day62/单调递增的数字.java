package com.wgx.hundred.day62;

/**
 * @author wgx
 * @since 2023/9/5 11:16
 */
public class 单调递增的数字 {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(322));
    }


    public static int monotoneIncreasingDigits(int n) {
        var s = String.valueOf(n).toCharArray();
        for (int i = 1; i < s.length; i++) {
            if (s[i] < s[i - 1]) {
                int j = i - 1;
                while (j > 0 && s[j] <= s[j - 1]) {
                    j--;
                }
                s[j]--;
                for (j++; j < s.length; j++) {
                    s[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(s));
    }
}
