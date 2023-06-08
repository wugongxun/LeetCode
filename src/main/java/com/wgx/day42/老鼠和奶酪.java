package com.wgx.day42;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2023/6/7 14:15
 */
public class 老鼠和奶酪 {
    @Test
    public void test() {
        System.out.println(miceAndCheese(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        var queue = new PriorityQueue<Integer>(Comparator.reverseOrder());

        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += reward1[i];
            queue.offer(reward2[i] - reward1[i]);
        }
        for (int i = 0; i < n - k; i++) {
            res += queue.poll();
        }
        return res;
    }

//    int n;
//    int[] reward1, reward2;
//
//    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
//        this.n = reward1.length;
//        this.reward1 = reward1;
//        this.reward2 = reward2;
//        return dfs(0, k, 0);
//    }
//
//    public int dfs(int i, int k, int res) {
//        if (i == n) {
//            return res;
//        }
//        if (k == 0) {
//            for (; i < n; ++i) {
//                res += reward2[i];
//            }
//            return res;
//        }
//
//        if (k == n - i) {
//            for (int j = 0; j < k; ++j) {
//                res += reward1[i + j];
//            }
//            return res;
//        }
//
//        //给第一只吃
//        int res1 = dfs(i + 1, k - 1, res + reward1[i]);
//        //给第二只吃
//        int res2 = dfs(i + 1, k, res + reward2[i]);
//        return Math.max(res1, res2);
//    }
}
