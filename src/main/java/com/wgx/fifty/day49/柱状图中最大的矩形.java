package com.wgx.fifty.day49;

import java.util.LinkedList;

/**
 * @author wgx
 * @since 2023/7/12 16:49
 */
public class 柱状图中最大的矩形 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        var left = new int[n];
        var right = new int[n];

        var stack = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }


        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }

//    public static int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        int res = 0;
//        for (int i = 0; i < n; ++i) {
//            int min = Integer.MAX_VALUE;
//            for (int j = i; j < n; ++j) {
//                min = Math.min(min, heights[j]);
//                res = Math.max(res, min * (j - i + 1));
//            }
//        }
//        return res;
//    }
}
