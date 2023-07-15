package com.wgx.fifty.day30;

/**
 * @author wgx
 * @since 2023/3/17 11:04
 * <p>
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * <p>
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的 最短时间 。
 */
public class 任务调度器 {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'}, 2));
    }

    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        var count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }

        var maxCount = 0;
        var maxSize = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == maxSize) {
                maxCount++;
            } else if (count[i] > maxSize) {
                maxSize = count[i];
                maxCount = 1;
            }
        }

        return Math.max((maxSize - 1) * (n + 1) + maxCount, tasks.length);
    }
}
