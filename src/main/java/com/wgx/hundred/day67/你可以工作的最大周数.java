package com.wgx.hundred.day67;

/**
 * @author wgx
 * @since 2024/5/19 16:19
 */
public class 你可以工作的最大周数 {
    public static void main(String[] args) {
        System.out.println(numberOfWeeks(new int[]{1, 2, 3}));
    }

    public static long numberOfWeeks(int[] milestones) {
        int max = milestones[0];
        long sum = 0;
        for (int milestone : milestones) {
            max = Math.max(max, milestone);
            sum += milestone;
        }
        sum -= max;
        return max > sum + 1 ? sum * 2 + 1 : sum + max;
    }
}
