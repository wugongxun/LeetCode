package com.wgx.hundred.day66;

/**
 * @author wgx
 * @since 2024/3/10 13:20
 */
public class 猜数字游戏 {

    public static void main(String[] args) {
        System.out.println(getHint("11", "10"));
    }

    public static String getHint(String secret, String guess) {
        var sb1 = new StringBuilder(secret);
        var sb2 = new StringBuilder(guess);
        int bulls = 0;
        int cows = 0;
        var count = new int[10];
        int n = sb1.length();
        for (int i = 0; i < n; ++i) {
            if (sb1.charAt(i) == sb2.charAt(i)) {
                bulls++;
                sb1.setCharAt(i, '#');
                sb2.setCharAt(i, '#');
            } else {
                count[sb1.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (sb2.charAt(i) != '#' && count[sb2.charAt(i) - '0'] != 0) {
                count[sb2.charAt(i) - '0']--;
                cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

}
