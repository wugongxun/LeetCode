package com.wgx.周赛.第354场周赛;

import java.util.*;

/**
 * @author wgx
 * @since 2023/7/16 11:33
 */
public class 合法分割的最小下标 {
    public static void main(String[] args) {
        //3,3,3,3,7,2,2
        var list = new ArrayList<Integer>();
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(2);
        System.out.println(minimumIndex(list));
    }

    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        var map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        int cur = 0;
        var prefix = new int[n];
        for (int i = 0; i < n; i++) {
            var num = nums.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > map.get(cur)) {
                cur = num;
            }
            prefix[i] = map.get(cur) * 2 > i + 1 ? cur : -1;
        }
        cur = 0;
        map.clear();
        map.put(0, 0);
        var suffix = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            var num = nums.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > map.get(cur)) {
                cur = num;
            }
            suffix[i] = map.get(cur) * 2 > n - i ? cur : -1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] == suffix[i + 1] && prefix[i] != -1) {
                return i;
            }
        }
        return -1;
    }
}
