package com.wgx.fifty.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/7 16:43
 */
public class 第一个错误的版本 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }
    static List<Integer> cache = new ArrayList<>();
    public static int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int fine = 1;
        int bad = n;
        int mid;
        while (bad - fine > 1) {
            mid = (int) (Math.addExact((long) fine, (long) bad) / 2);
            if (isBadVersion(mid))
                bad = mid;
            else
                fine = mid;
        }
        return isBadVersion(fine) ? fine : bad;
    }

    private static boolean isBadVersion(int n) {
        return n >= 1702766719;
    }

}
