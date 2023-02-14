package com.wgx.day22;

import java.util.Stack;

/**
 * @author wgx
 * @since 2023/2/14 9:49
 */
public class 表现良好的最长时间段 {
    public static void main(String[] args) {
        System.out.println(longestWPI(new int[]{13,4,2,5,0,6,0,10,5,12,5}));
    }

    public static int longestWPI(int[] hours) {
        int n = hours.length;
        int[] prefix = new int[n + 1];
        var stack = new Stack<Integer>();
        stack.push(0);
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (prefix[stack.peek()] > prefix[i]) {
                stack.push(i);
            }
        }
        int res = 0;
        for (int i = n; i >= 1; i--) {
            while (!stack.isEmpty() && prefix[i] > prefix[stack.peek()]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}
