package com.wgx.周赛.第360场周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/8/27 10:41
 */
public class 使子序列的和等于目标的最少操作次数 {
    public static void main(String[] args) {
        var nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(32);
        nums.add(1);
        nums.add(2);
        System.out.println(minOperations(nums, 12));
    }

    public static int minOperations(List<Integer> nums, int target) {
        if (nums.stream().mapToLong(Long::valueOf).reduce(0L, Long::sum) < target) {
            return -1;
        }
        var count = new int[32];
        nums.forEach(num -> count[Integer.numberOfTrailingZeros(num)]++);
        int res = 0, i = 0, sum = 0;
        while (1L << i <= target) {
            sum += count[i] << i;
            int mask = (1 << (i + 1)) - 1;
            i++;
            if (sum >= (target & mask)) {
                continue;
            }
            res++;
            while (count[i] == 0) {
                i++;
                res++;
            }
        }
        return res;
    }

//    public static int minOperations(List<Integer> nums, int target) {
//        var count = new int[32];
//        nums.forEach(num -> count[Integer.numberOfTrailingZeros(num)]++);
//        int res = 0;
//        var bs = new StringBuilder(Integer.toBinaryString(target)).reverse();
//        for (int i = 0; i < bs.length(); i++) {
//            var ch = bs.charAt(i);
//            if (ch == '1' && count[i] == 0) {
//                int j = i + 1;
//                while (j < 32 && count[j] == 0) {
//                    j++;
//                }
//                if (j == 32) {
//                    return -1;
//                }
//                while (j > i) {
//                    count[j--]--;
//                    count[j] += 2;
//                    res++;
//                }
//            }
//            count[i] -= ch - '0';
//            count[i + 1] += count[i] / 2;
//        }
//        return res;
//    }
}
