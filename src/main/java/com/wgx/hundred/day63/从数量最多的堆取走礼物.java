package com.wgx.hundred.day63;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2023/10/28 12:31
 */
public class 从数量最多的堆取走礼物 {
    public static void main(String[] args) {
        System.out.println(pickGifts(new int[]{25, 64, 9, 4, 100}, 4));
    }

    public static long pickGifts(int[] gifts, int k) {
        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (var gift : gifts) {
            pq.offer(gift);
        }
        for (int i = 0; i < k; ++i) {
            var mx = pq.poll();
            pq.offer((int) Math.floor(Math.sqrt(mx)));
        }
        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }
}
