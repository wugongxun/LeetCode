package com.wgx.day48;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2023/7/7 14:21
 */
public class 过桥的时间 {
    @Test
    public void test() {
//        System.out.println(findCrossingTime(1, 3, new int[][]{
//                {1, 1, 2, 1}, {1, 1, 3, 1}, {1, 1, 4, 1}
//        }));
        System.out.println(findCrossingTime(3, 2, new int[][]{
                {1, 9, 1, 8}, {10, 10, 10, 10}
        }));
    }

    public int findCrossingTime(int n, int k, int[][] time) {
        Comparator<Integer> waitComparator = (o1, o2) -> {
            int time1 = time[o1][0] + time[o1][2];
            int time2 = time[o2][0] + time[o2][2];
            return time1 == time2 ? o2 - o1 : time2 - time1;
        };
        var waitLeft = new PriorityQueue<>(waitComparator);
        var waitRight = new PriorityQueue<>(waitComparator);
        Comparator<int[]> workComparator = (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        var workLeft = new PriorityQueue<>(workComparator);
        var workRight = new PriorityQueue<>(workComparator);
        int curTime = 0;
        for (int i = 0; i < k; i++) {
            waitLeft.offer(i);
        }
        while (n > 0 || !waitRight.isEmpty() || !workRight.isEmpty()) {
            while (!workLeft.isEmpty() && workLeft.peek()[0] <= curTime) {
                waitLeft.offer(workLeft.poll()[1]);
            }
            while (!workRight.isEmpty() && workRight.peek()[0] <= curTime) {
                waitRight.offer(workRight.poll()[1]);
            }

            if (!waitRight.isEmpty()) {
                int id = waitRight.poll();
                curTime += time[id][2];
                workLeft.offer(new int[]{curTime + time[id][3], id});
            } else if (n > 0 && !waitLeft.isEmpty()) {
                int id = waitLeft.poll();
                curTime += time[id][0];
                workRight.offer(new int[]{curTime + time[id][1], id});
                n--;
            } else {
                int nextTime = Integer.MAX_VALUE;
                if (!workLeft.isEmpty()) {
                    nextTime = Math.min(nextTime, workLeft.peek()[0]);
                }
                if (!workRight.isEmpty()) {
                    nextTime = Math.min(nextTime, workRight.peek()[0]);
                }
                if (nextTime != Integer.MAX_VALUE) {
                    curTime = Math.max(nextTime, curTime);
                }
            }

        }
        return curTime;
    }
}
