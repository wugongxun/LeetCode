package com.wgx.周赛.第338场周赛;

/**
 * @author wgx
 * @since 2023/3/26 10:36
 */
public class 质数减法运算 {
    public static void main(String[] args) {
        System.out.println(primeSubOperation(new int[]{2,2}));
    }

    public static boolean primeSubOperation(int[] nums) {
        //求出1-1000的所有质数
        var prime = new boolean[1001];
        label:
        for (int i = 2; i <= 1000; ++i) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime[i] = false;
                    continue label;
                }
            }
            prime[i] = true;
        }


        int n = nums.length;
        for (int i = 1; i < nums[0]; i++) {
            if (prime[nums[0] - i]) {
                nums[0] = i;
                break;
            }
        }

        label:
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < nums[i]; j++) {
                if (prime[nums[i] - j] && j > nums[i - 1]) {
                    nums[i] = j;
                    continue label;
                }
            }
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
