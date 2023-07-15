package com.wgx.周赛.第338场周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/3/26 11:07
 */
public class 使数组元素全部相等的最少操作次数 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{3,1,6,8}, new int[]{1, 5}));
    }

    public static List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length, m = queries.length;
        var prefix = new long[n + 1];
        //前缀和
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        var res = new ArrayList<Long>(m);
        for (int i = 0; i < m; ++i) {
            int query = queries[i];
            int index = Arrays.binarySearch(nums, query);
            if (index < 0) {
                index = -index - 1;
            }
            long temp = (index * (long) query - prefix[index]) + (prefix[n] - prefix[index] - ((n - index) * (long) query));
            res.add(temp);
        }
        return res;



//        int n = nums.length, m = queries.length;
//        var res = new ArrayList<Long>(m);
//        for (int i = 0; i < m; i++) {
//            int query = queries[i];
//            long temp = 0;
//            for (int j = 0; j < n; j++) {
//                temp += Math.abs(query - nums[j]);
//            }
//            res.add(temp);
//        }
//        return res;
    }
}
