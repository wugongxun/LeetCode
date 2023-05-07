package com.wgx.day39;

/**
 * @author wgx
 * @since 2023/5/7 14:32
 */
public class 总持续时间可被60整除的歌曲 {
    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        var mods = new int[61];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            var mod = time[i] % 60;
            if (mod == 0) {
                res += mods[0]++;
            } else {
                res += mods[60 - mod];
                mods[mod]++;
            }
        }
        return res;
    }
}
