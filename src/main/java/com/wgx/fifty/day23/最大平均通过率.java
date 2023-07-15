package com.wgx.fifty.day23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2023/2/19 14:30
 *
 * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。
 *
 * 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
 *
 * 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。
 *
 * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。
 */
public class 最大平均通过率 {
    public static void main(String[] args) {
        System.out.println(maxAverageRatio(new int[][]{
                {1, 2},
                {3, 5},
                {2, 2}
        }, 2));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        var passRate = new PriorityQueue<int[]>(Comparator.comparingDouble(o -> (double) o[0] / o[1] - (double) (o[0] + 1) / (o[1] + 1)));
        for (int i = 0; i < classes.length; i++) {
            passRate.offer(new int[]{classes[i][0], classes[i][1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] poll = passRate.poll();
            passRate.offer(new int[]{poll[0] + 1, poll[1] + 1});
        }

        double res = 0;
        while (!passRate.isEmpty()) {
            int[] poll = passRate.poll();
            res += (double) poll[0] / poll[1];
        }
        return res / classes.length;
    }
}
