package com.wgx.周赛.第337场周赛;

/**
 * @author wgx
 * @since 2023/3/19 11:42
 */
public class 执行操作后的最大MEX {
    public static void main(String[] args) {
        System.out.println(findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5));
    }

    public static int findSmallestInteger(int[] nums, int value) {
        var count = new int[value];
        //求出与num同余
        for (int num : nums) {
            count[(num % value + value) % value]++;
        }

        for (int i = 0; ; i++) {
            if (--count[i % value] < 0) {
                return i;
            }
        }
    }
}
