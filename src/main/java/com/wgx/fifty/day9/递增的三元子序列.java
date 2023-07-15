package com.wgx.fifty.day9;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/21 10:59
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvvuqg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 递增的三元子序列 {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13}));
    }

    public static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
            if (nums[i] < mid)
                mid = nums[i];
            else
                return true;
        }
        return false;
//        int length = nums.length;
//        ArrayList<Integer> iList = new ArrayList<>();
//        ArrayList<Integer> jList = new ArrayList<>();
//        for (int i = 0; i < length - 2; i++) {
//            if (iList.contains(nums[i])) {
//                continue;
//            }
//            iList.add(nums[i]);
//            for (int j = i + 1; j < length - 1 ; j++) {
//                if (nums[i] >= nums[j])
//                    continue;
//                if (jList.contains(nums[j])) {
//                    continue;
//                }
//                jList.add(nums[j]);
//                for (int k = j + 1; k < length; k++) {
//                    if (nums[j] >= nums[k])
//                        continue;
//                    return true;
//                }
//            }
//        }
//        return false;
    }
}