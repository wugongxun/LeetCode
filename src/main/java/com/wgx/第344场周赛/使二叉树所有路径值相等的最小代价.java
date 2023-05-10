package com.wgx.第344场周赛;

/**
 * @author wgx
 * @since 2023/5/7 11:17
 */
public class 使二叉树所有路径值相等的最小代价 {
    public static void main(String[] args) {
        System.out.println(minIncrements(7, new int[]{1,5,2,2,3,3,1}));

//        System.out.println(minIncrements(15, new int[]{764, 1460, 2664, 764, 2725, 4556, 5305, 8829, 5064, 5929, 7660, 6321, 4830, 7055, 3761}));
    }

    public static int minIncrements(int n, int[] cost) {
        int res = 0;
        for (int i = n / 2; i > 0; --i) {
            res += Math.abs(cost[i * 2 - 1] - cost[i * 2]);
            cost[i - 1] += Math.max(cost[i * 2 - 1], cost[i * 2]);
        }
        return res;
    }

//    public static int minIncrements(int n, int[] cost) {
//        int res = 0;
//        var maxPath = new int[n + 1];
//        for (int i = n; i >= 1; --i) {
//            int max = 0;
//            if (i * 2 + 1 <= n) {
//                max = Math.max(maxPath[2 * i], maxPath[2 * i + 1]);
//            }
//            maxPath[i] = max + cost[i - 1];
//        }
//
//        var deque = new LinkedList<Integer>();
//        deque.add(1);
//        while (!deque.isEmpty()) {
//            int size = deque.size();
//            for (int i = 0; i < size; ++i) {
//                Integer poll = deque.pollFirst();
//
//                if (2 * poll + 1 <= n) {
//                    res += maxPath[poll] - maxPath[2 * poll] - cost[poll - 1];
//                    res += maxPath[poll] - maxPath[2 * poll + 1] - cost[poll - 1];
//
//                    deque.add(2 * poll);
//                    deque.add(2 * poll + 1);
//                }
//            }
//        }
//
//        return res;
//    }
}
