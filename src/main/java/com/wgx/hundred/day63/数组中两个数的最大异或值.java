package com.wgx.hundred.day63;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author wgx
 * @since 2023/11/4 9:57
 */
public class 数组中两个数的最大异或值 {
    @Test
    public void test() {
        System.out.println(findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }

    public int findMaximumXOR(int[] nums) {
        final int HIGH_GIT = 30;
        int x = 0;
        for (int k = HIGH_GIT; k >= 0; k--) {
            var set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num >> k);
            }
            int xNext = (x << 1) + 1;
            var found = false;
            for (int num : nums) {
                if (set.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            if (found) {
                x = xNext;
            } else {
                x = xNext - 1;
            }
        }
        return x;
    }
}
