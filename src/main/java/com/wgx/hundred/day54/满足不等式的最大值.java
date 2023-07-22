package com.wgx.hundred.day54;

import java.util.LinkedList;

/**
 * @author wgx
 * @since 2023/7/21 14:48
 */
public class 满足不等式的最大值 {
    public static void main(String[] args) {
        System.out.println(findMaxValueOfEquation(new int[][]{
                {1, 3}, {2, 0}, {5, 10}, {6, -10}
        }, 1));
    }

    //单调队列
    public static int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        var deque = new LinkedList<int[]>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            var point = points[i];
            while (!deque.isEmpty() && point[0] - deque.peekFirst()[0] > k)
                deque.pollFirst();
            if (!deque.isEmpty())
                res = Math.max(res, deque.peekFirst()[1] + point[0] + point[1]);
            while (!deque.isEmpty() && point[1] - point[0] >= deque.peekLast()[1])
                deque.pollLast();
            deque.offerLast(new int[]{point[0], point[1] - point[0]});
        }
        return res;
    }


//    优先队列
//    public static int findMaxValueOfEquation(int[][] points, int k) {
//        int n = points.length;
//        var pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i < n; ++i) {
//            var point = points[i];
//            while (!pq.isEmpty() && point[0] - pq.peek()[0] > k)
//                pq.poll();
//            if (!pq.isEmpty())
//                res = Math.max(res, pq.peek()[1] + point[0] + point[1]);
//            pq.offer(new int[]{point[0], point[1] - point[0]});
//        }
//        return res;
//    }
}
