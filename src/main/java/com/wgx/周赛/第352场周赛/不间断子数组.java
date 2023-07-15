package com.wgx.周赛.第352场周赛;

import java.util.TreeMap;

/**
 * @author wgx
 * @since 2023/7/2 11:36
 */
public class 不间断子数组 {
    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[]{5, 4, 2, 4}));
//        System.out.println(continuousSubarrays(new int[]{1, 2, 3}));
    }

    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long res = 0;
        int left = 0;
        var map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.lastKey() - map.firstKey() > 2) {
                int y = nums[left];
                map.put(y, map.get(y) - 1);
                if (map.get(y) == 0) {
                    map.remove(y);
                }
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }

//    public static long continuousSubarrays(int[] nums) {
//        int n = nums.length;
//        //[start, end, max, min]
//        var deque = new ArrayDeque<int[]>();
//        for (int i = 0; i < n; i++) {
//            deque.offerLast(new int[]{i, i, nums[i], nums[i]});
//        }
//        int res = n;
//        while (!deque.isEmpty()) {
//            int size = deque.size();
//            for (int j = 0; j < size; j++) {
//                var arr = deque.pollFirst();
//                arr[1]++;
//                if (arr[1] >= n) {
//                    continue;
//                }
//                arr[2] = Math.max(arr[2], nums[arr[1]]);
//                arr[3] = Math.min(arr[3], nums[arr[1]]);
//                int abs = Math.abs(arr[2] - arr[3]);
//                if (abs >= 0 && abs <= 2) {
//                    deque.offerLast(arr);
//                }
//            }
//            res += deque.size();
//        }
//        return res;
//    }
}
