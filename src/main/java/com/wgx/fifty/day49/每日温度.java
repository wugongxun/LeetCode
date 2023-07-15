package com.wgx.fifty.day49;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wgx
 * @since 2023/7/11 22:23
 */
public class 每日温度 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        var res = new int[n];
        var queue = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            int temperature = temperatures[i];
            while (!queue.isEmpty() && temperatures[queue.peek()] < temperature) {
                Integer index = queue.pop();
                res[index] = i - index;
            }
            queue.push(i);
        }
        return res;
    }
}
