package com.wgx.hundred.day66;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author wgx
 * @since 2024/5/19 13:41
 */
public class 找出数组游戏的赢家 {

    @Test
    public void test() {
        System.out.println(getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
    }

    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        if (k >= n) {
            return Arrays.stream(arr).max().getAsInt();
        }
        var deque = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            deque.addLast(i);
        }
        var cnt = new int[n];
        while (true) {
            int a0 = deque.pollFirst();
            int a1 = deque.pollFirst();
            if (arr[a0] > arr[a1]) {
                handle(a0, a1, deque, cnt);
                if (cnt[a0] >= k) {
                    return arr[a0];
                }
            } else {
                handle(a1, a0, deque, cnt);
                if (cnt[a1] >= k) {
                    return arr[a1];
                }
            }
        }
    }

    public void handle(int winner, int loser, Deque<Integer> deque, int[] cnt) {
        deque.addFirst(winner);
        cnt[winner]++;
        deque.addLast(loser);
        cnt[loser] = 0;
    }

}
