package com.wgx.day16;

import java.util.*;

/**
 * @author wgx
 * @since 2023/1/14 13:30
 */
public class 序列中不同最大公约数的数目 {
    public static void main(String[] args) {
        System.out.println(countDifferentSubsequenceGCDs(new int[]{6, 10, 3}));
    }

    public static int countDifferentSubsequenceGCDs(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt();
        boolean[] occured = new boolean[maxVal + 1];
        for (int num : nums) {
            occured[num] = true;
        }
        int res = 0;
        for (int i = 1; i <= maxVal; i++) {
            int subGcd = 0;
            for (int j = i; j <= maxVal; j += i) {
                if (occured[j]) {
                    if (subGcd == 0) {
                        subGcd = j;
                    } else {
                        subGcd = gcd(subGcd, j);
                    }
                    if (subGcd == i) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static int gcd(int m, int n) {
        while (n != 0) {
            int temp = m;
            m = n;
            n = temp % n;
        }
        return m;
    }

//    public static int countDifferentSubsequenceGCDs(int[] nums) {
//        HashSet<Integer> res = new HashSet<>();
//        backtrack(nums, 0, new ArrayList<>(), 0, res);
//        return res.size();
//    }

    public static void backtrack(int[] nums, int index, List<Integer> list, int gcd, Set<Integer> set) {
        if (index == nums.length) {
            if (!list.isEmpty()) {
                set.add(gcd);
            }
            return;
        }
        if (gcd == 1) {
            set.add(1);
            return;
        }
        backtrack(nums, index + 1, list, gcd, set);
        int num = nums[index];
        if (gcd != 0) {
            int temp;
            //求出最大公约数
            while ((temp = num % gcd) != 0) {
                num = gcd;
                gcd = temp;
            }
        } else {
            gcd = num;
        }
        list.add(num);
        backtrack(nums, index + 1, list, gcd, set);
        list.remove(list.size() - 1);
    }
}
