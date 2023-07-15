package com.wgx.fifty.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/25 15:03
 */
public class 两个数组的交集 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map1.containsKey(nums1[i])) {
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            } else {
                map1.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i])) {
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            } else {
                map2.put(nums2[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key = entry.getKey();
            if (map2.containsKey(key)) {
                int times = Math.min(map1.get(key), map2.get(key));
                for (int i = 0; i < times; i++) {
                    res.add(key);
                }
            }
        }
        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }
}
