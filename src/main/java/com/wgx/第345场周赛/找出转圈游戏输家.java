package com.wgx.第345场周赛;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author wgx
 * @since 2023/5/14 10:38
 */
public class 找出转圈游戏输家 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularGameLosers(5, 2)));
    }

    public static int[] circularGameLosers(int n, int k) {
        var set = new HashSet<Integer>();
        int cur = 0;
        int times = 1;
        while (true) {
            if (!set.add(cur)) {
                break;
            }
            cur = (cur + times * k) % n;
            times++;
        }

        var res = new int[n - set.size()];
        int index = 0;
        for (int i = 1; i <= n; ++i) {
            if (!set.contains(i - 1)) {
                res[index] = i;
                index++;
            }
        }

        return res;
    }
}
