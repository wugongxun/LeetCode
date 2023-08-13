package com.wgx.hundred.day61;

import java.util.Comparator;
import java.util.PriorityQueue;

;

/**
 * @author wgx
 * @since 2023/8/11 11:40
 */
public class 有序矩阵中第K小的元素 {
    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{
                {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        }, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            //每一行最小的数，第几行，第几列
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            var poll = pq.poll();
            if (poll[2] != n - 1) {
                pq.offer(new int[]{matrix[poll[1]][poll[2] + 1], poll[1], poll[2] + 1});
            }
        }
        return pq.peek()[0];
    }
}
