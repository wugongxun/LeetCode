package com.wgx.fifty.day6;

import java.util.*;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/9 9:26
 */
public class 打乱数组 {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}
class Solution {
    private int[] originalArr;
    private Random random;

    public Solution(int[] nums) {
        random = new Random();
        this.originalArr = nums;
    }

    public int[] reset() {
        return this.originalArr;
    }

    public int[] shuffle() {
        int[] temp = this.originalArr.clone();
        for (int i = 1; i < temp.length; i++) {
            int j = random.nextInt(i + 1);
            swap(temp, i, j);
        }
        return temp;
    }

    public void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
    }
}
