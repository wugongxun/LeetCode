package com.wgx.华为OD;

import java.util.*;

/**
 * @author wgx
 * @since 2023/8/2 19:00
 * <p>
 * 给定一个乱序的数组, 删除所有的重复元素,
 * <p>
 * 使得每个元素只出现一次, 并且按照出现的次数从高到低进行排序,
 * <p>
 * 相同出现次数按照第一次出现顺序进行先后排序.
 * <p>
 * 示例
 * <p>
 * 输入: 1,3,3,3,2,4,4,4,5
 * <p>
 * 输出: 3,4,1,2,5
 */
public class 数组去重和排序 {
    public static void main(String[] args) {
        System.out.println(f(new int[]{1, 3, 3, 3, 2, 4, 4, 4, 5}));
    }

    public static List<Integer> f(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        var list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        return list;
    }
}







