package com.wgx.hundred.day52;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/7/16 22:26
 */
public class 行星碰撞 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, -2, 1, -2})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            int asteroid = asteroids[i];
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            } else {
                int t = -asteroid;
                var flag = true;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int pop = stack.pop();
                    if (t == pop) {
                        flag = false;
                        break;
                    }
                    if (pop > t) {
                        stack.push(pop);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    stack.push(asteroid);
                }
            }
        }
        var res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            res[i] = stack.pop();
        }
        return res;
    }
}
