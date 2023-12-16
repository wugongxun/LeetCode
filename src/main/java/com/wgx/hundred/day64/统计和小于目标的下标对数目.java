package com.wgx.hundred.day64;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wgx
 * @since 2023/11/24 19:54
 */
public class 统计和小于目标的下标对数目 {
    @Test
    public void test() {
        System.out.println(countPairs(Arrays.asList(-1, 1, 2, 3, 1), 2));
    }

    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int res = 0;
        for (int i = 0, j = nums.size() - 1; i < j; i++) {
            while (i < j && nums.get(i) + nums.get(j) >= target)
                j--;
            res += j - i;
        }
        return res;
    }

//    public int countPairs(List<Integer> nums, int target) {
//        Collections.sort(nums);
//        int res = 0;
//        for (int i = 0; i < nums.size(); i++) {
//            res += binarySearch(nums, 0, i - 1, target - nums.get(i));
//        }
//        return res;
//    }
//
//    private int binarySearch(List<Integer> nums, int l, int r, int key) {
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            if (nums.get(mid) >= key) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return l;
//    }
}
