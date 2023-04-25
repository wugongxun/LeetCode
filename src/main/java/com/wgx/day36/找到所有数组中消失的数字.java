package com.wgx.day36;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/4/25 9:36
 */
public class 找到所有数组中消失的数字 {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{1,1,2,2}));
    }



    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        var arr = new int[n + 1];
        for (int num : nums) {
            arr[num] = 1;
        }
        var res = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                res.add(i);
            }
        }
        return res;

//        int n = nums.length;
//        for (int i = 0; i < n; ++i) {
//            int abs = Math.abs(nums[i]);
//            nums[abs - 1] = -Math.abs(nums[abs - 1]);
//        }
//
//        var res = new ArrayList<Integer>();
//        for (int i = 0; i < n; ++i) {
//            if (nums[i] > 0) {
//                res.add(i + 1);
//            }
//        }
//        return res;


//        Arrays.sort(nums);
//        int n = nums.length;
//        var res = new ArrayList<Integer>();
//        int cur = 1;
//        int p = 0;
//        while (cur <= n) {
//            if (p >= n || nums[p] > cur) {
//                res.add(cur);
//                cur++;
//            } else if (nums[p] == cur) {
//                cur++;
//            } else {
//                p++;
//            }
//        }
//        return res;
    }
}
