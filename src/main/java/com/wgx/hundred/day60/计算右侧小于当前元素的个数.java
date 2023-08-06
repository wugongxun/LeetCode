package com.wgx.hundred.day60;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wgx
 * @since 2023/8/4 15:12
 */
public class 计算右侧小于当前元素的个数 {
    @Test
    public void test() {
        System.out.println(countSmaller(new int[]{3, 9, 5, 2, 6, 1 ,3}));
    }

    int[] a, c;

    public List<Integer> countSmaller(int[] nums) {
        var res = new ArrayList<Integer>();
        discretization(nums);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            res.add(query(id));
            update(id + 1);
        }
        Collections.reverse(res);
        return res;
    }

    public void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    public int query(int pos) {
        int res = 0;
        while (pos > 0) {
            res += c[pos];
            pos -= lowBit(pos);
        }
        return res;
    }

    public void discretization(int[] nums) {
        //去重
        var set = new HashSet<Integer>();
        for (var num : nums) {
            set.add(num);
        }
        //转换为离散数组
        a = new int[set.size()];
        int index = 0;
        for (var num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
        c = new int[nums.length + 5];
    }

    public int lowBit(int x) {
        return x & -x;
    }

    public int getId(int x) {
        return Arrays.binarySearch(a, x);
    }
}
