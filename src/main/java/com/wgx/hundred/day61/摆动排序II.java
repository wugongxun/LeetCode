package com.wgx.hundred.day61;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/8/9 15:10
 */
public class 摆动排序II {
    public static void main(String[] args) {

    }

    public static void wiggleSort(int[] nums) {
        var arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n)
                nums[i + 1] = arr[k];
        }
    }
}
