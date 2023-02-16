package com.wgx.day22;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/2/15 9:55
 */
public class 检查好数组 {
    public static void main(String[] args) {
        System.out.println(isGoodArray(new int[]{18,18,18,15,54,45,45,45}));
    }

    public static boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((divisor = gcd(divisor, nums[i])) == 1)
                break;
        }
        return divisor == 1;
    }

    public static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
