package com.wgx.第350场周赛;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/6/18 10:47
 */
public class 特别的排列 {
    @Test
    public void test() {
        System.out.println(specialPerm(new int[]{2, 3, 5, 7}));
        System.out.println(specialPerm(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192}));
        long res = 1 ;
        for (int i = 1; i <= 14; i++) {
            res *= i;
            res = res % 1000000007;
        }
        System.out.println(res);
    }

    int n;
    int[] nums;
    long[][] cache;

    public int specialPerm(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.cache = new long[1 << n][n];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(cache[i], -1);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += dfs(1 << i, i);

        }
        return (int) (res % 1000000007);
    }

    public long dfs(int bit, int pre) {
        if (bit == (1 << n) - 1) {
            return 1;
        }
        if (cache[bit][pre] != -1) {
            return cache[bit][pre];
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            if ((bit >> i & 1) == 0 && (nums[pre] % nums[i] == 0 || nums[i] % nums[pre] == 0)) {
                count += dfs(bit | 1 << i, i);
            }
        }
        return cache[bit][pre] = count;
    }

//    int n;
//    HashMap<Integer, List<Integer>> map;
//    ArrayList<Integer> used;
//
//    public int specialPerm(int[] nums) {
//        this.n = nums.length;
//        map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            var num = nums[i];
//            map.put(num, new ArrayList<>());
//            for (int j = 0; j < n; j++) {
//                if (i != j && (num % nums[j] == 0 || nums[j] % num == 0)) {
//                    map.get(num).add(nums[j]);
//                }
//            }
//        }
//
//        used = new ArrayList<>();
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            used.add(nums[i]);
//            res += dfs(1, nums[i]);
//            used.clear();
//        }
//        return res;
//    }
//
//    public int dfs(int i, int pre) {
//        if (i == n) {
//            return 1;
//        }
//        int count = 0;
//        for (Integer cur : map.get(pre)) {
//            if (!used.contains(cur)) {
//                used.add(cur);
//                count += dfs(i + 1, cur);
//                used.remove(used.size() - 1);
//            }
//        }
//        return count;
//    }
}
