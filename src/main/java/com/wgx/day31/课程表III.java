package com.wgx.day31;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2023/3/23 10:37
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
 *
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 *
 * 返回你最多可以修读的课程数目。
 */
public class 课程表III {
    public static void main(String[] args) {

    }

    public static int scheduleCourse(int[][] courses) {
        //按照结束时间排序，优先选择结束时间早的课程
        Arrays.sort(courses, Comparator.comparingInt(i -> i[1]));
        //优先队列保存已选择的课程的持续时间
        var queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int total = 0;
        for (int[] course : courses) {
            int t = course[0], d = course[1];
            if (total + t <= d) {
                //如果第i个课程的时间+已选择的课程的总时间 <= 第i个课程的结束时间，则第i个课程可以直接选择
                total += t;
                queue.offer(t);
            } else if (!queue.isEmpty() && queue.peek() > t) {
                //如果第i个课程无法直接选择，但是已选择的课程中有持续时间要大于第i个课程的持续时间
                //则可以将第i个课程替换queue中的时间最长的课程，来缩短花费的总时间
                total -= queue.poll() - t;
                queue.offer(t);
            }
        }

        return queue.size();


//        Arrays.sort(courses, Comparator.comparingInt(i -> i[1]));
//        return dfs(courses, 0, 0, 0);
    }

//    public static int dfs(int[][] courses, int index, int startDay, int res) {
//        if (index == courses.length) {
//            return res;
//        }
//        //不选
//        int noSelect = dfs(courses, index + 1, startDay, res);
//
//        //选
//        int select = 0;
//        if (startDay + courses[index][0] <= courses[index][1]) {
//            select = dfs(courses, index + 1, startDay + courses[index][0], res + 1);
//        }
//        return Math.max(noSelect, select);
//    }
}
