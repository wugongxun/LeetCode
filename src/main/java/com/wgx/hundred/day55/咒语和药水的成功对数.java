package com.wgx.hundred.day55;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/7/26 17:50
 */
public class 咒语和药水的成功对数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        var res = new int[n];
        for (int i = 0; i < n; ++i) {
            int l = 0, r = m - 1;
            int spell = spells[i];
            while (l <= r) {
                int mid = (l + r) / 2;
                int t = spell * potions[mid];
                if (t >= success) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            res[i] = m - l;
        }
        return res;
    }
}
