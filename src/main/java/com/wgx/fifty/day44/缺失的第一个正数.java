package com.wgx.fifty.day44;

/**
 * @author wgx
 * @since 2023/6/15 10:58
 */
public class 缺失的第一个正数 {
    public static void main(String[] args) {
//        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    //    原地算法，O(n)，O(1)
//    public static int firstMissingPositive(int[] nums) {
//        int n = nums.length;
//        for (int i = 0; i < n; ++i) {
//            if (nums[i] <= 0)
//                nums[i] = n + 1;
//        }
//
//        for (int i = 0; i < n; ++i) {
//            int num = Math.abs(nums[i]);
//            if (num <= n) {
//                nums[num - 1] = -Math.abs(nums[num - 1]);
//            }
//        }
//
//        for (int i = 0; i < n; ++i) {
//            if (nums[i] > 0) {
//                return i + 1;
//            }
//        }
//        return n + 1;
//    }

//    hash表，O(n)，O(n)
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        var seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n) {
                seen[nums[i] - 1] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!seen[i - 1])
                return i;
        }
        return n + 1;
    }

//    排序，O(nlogn)，O(1)
//    public static int firstMissingPositive(int[] nums) {
//        int n = nums.length;
//        Arrays.sort(nums);
//        int start = 0;
//        while (start < n && nums[start] <= 0) {
//            start++;
//        }
//        if (start >= n || nums[start] != 1) {
//            return 1;
//        }
//        for (int i = start + 1; i < n; ++i) {
//            if (nums[i] != nums[i - 1] && nums[i] != nums[i - 1] + 1 && nums[i - 1] + 1 > 0) {
//                return nums[i - 1] + 1;
//            }
//        }
//        return nums[n - 1] + 1;
//    }
}
