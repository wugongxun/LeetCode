package com.wgx.fifty.day17;

import java.util.*;

/**
 * @author wgx
 * @since 2023/1/18 9:50
 *
 * 给你两个整数 m 和 k ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值 。
 *
 * MK 平均值 按照如下步骤计算：
 *
 * 如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。
 * 从这个容器中删除最小的 k 个数和最大的 k 个数。
 * 计算剩余元素的平均值，并 向下取整到最近的整数 。
 * 请你实现 MKAverage 类：
 *
 * MKAverage(int m, int k) 用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象。
 * void addElement(int num) 往数据流中插入一个新的元素 num 。
 * int calculateMKAverage() 对当前的数据流计算并返回 MK 平均数 ，结果需 向下取整到最近的整数 。
 */
public class 求出MK平均值 {
    public static void main(String[] args) {
        MKAverage mkAverage = new MKAverage(3, 1);
        mkAverage.addElement(58916);
        mkAverage.addElement(61899);
        System.out.println(mkAverage.calculateMKAverage());
        mkAverage.addElement(85406);
        mkAverage.addElement(49757);
        System.out.println(mkAverage.calculateMKAverage());
        mkAverage.addElement(27520);
        mkAverage.addElement(12303);
        System.out.println(mkAverage.calculateMKAverage());
        mkAverage.addElement(63945);

    }


}

class MKAverage {
    private int m, k;
    private Queue<Integer> deque;
    private TreeMap<Integer, Integer> s1;
    private TreeMap<Integer, Integer> s2;
    private TreeMap<Integer, Integer> s3;
    private int size1, size2, size3;
    private long sum2;


    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.deque = new ArrayDeque<>();
        this.s1 = new TreeMap<>();
        this.s2 = new TreeMap<>();
        this.s3 = new TreeMap<>();
        this.size1 = 0;
        this.size2 = 0;
        this.size3 = 0;
        this.sum2 = 0;
    }

    public void addElement(int num) {
        //将num插入到deque
        deque.offer(num);
        int size = deque.size();
        //如果deque的size不大于m，将num插入到s2中，如果s2的size等于m，将两头的k个元素分别插入到s1，s3中
        if (size <= m) {
            s2.put(num, s2.getOrDefault(num, 0) + 1);
            sum2 += num;
            size2++;
            if (size == m) {
                while (size1 < k) {
                    Integer first = s2.firstKey();
                    s1.put(first, s1.getOrDefault(first, 0) + 1);
                    size1++;
                    sum2 -= first;
                    s2.put(first, s2.get(first) - 1);
                    if (s2.get(first) == 0) {
                        s2.remove(first);
                    }
                    size2--;
                }
                while (size3 < k) {
                    Integer last = s2.lastKey();
                    s3.put(last, s3.getOrDefault(last, 0) + 1);
                    size3++;
                    sum2 -= last;
                    s2.put(last, s2.get(last) - 1);
                    if (s2.get(last) == 0) {
                        s2.remove(last);
                    }
                    size2--;
                }
            }
            return;
        }

        //如果deque的size大于m，根据条件插入到s1或者s2或者s3中
        if (num < s1.lastKey()) {
            s1.put(num, s1.getOrDefault(num, 0) + 1);
            Integer last = s1.lastKey();
            s2.put(last, s2.getOrDefault(last, 0) + 1);
            sum2 += last;
            size2++;
            s1.put(last, s1.get(last) - 1);
            if (s1.get(last) == 0) {
                s1.remove(last);
            }
        } else if (num > s3.firstKey()) {
            s3.put(num, s3.getOrDefault(num, 0) + 1);
            Integer first = s3.firstKey();
            s2.put(first, s2.getOrDefault(first, 0) + 1);
            sum2 += first;
            size2++;
            s3.put(first, s3.get(first) - 1);
            if (s3.get(first) == 0) {
                s3.remove(first);
            }
        } else {
            s2.put(num, s2.getOrDefault(num, 0) + 1);
            size2++;
            sum2 += num;
        }


        //删除s1，s2，s3中多余的元素
        int del = deque.poll();
        if (s1.containsKey(del)) {
            s1.put(del, s1.get(del) - 1);
            if (s1.get(del) == 0) {
                s1.remove(del);
            }
            Integer first = s2.firstKey();
            s1.put(first, s1.getOrDefault(first, 0) + 1);
            s2.put(first, s2.get(first) - 1);
            if (s2.get(first) == 0) {
                s2.remove(first);
            }
            size2--;
            sum2 -= first;
        } else if (s3.containsKey(del)) {
            s3.put(del, s3.get(del) - 1);
            if (s3.get(del) == 0) {
                s3.remove(del);
            }
            Integer last = s2.lastKey();
            s3.put(last, s3.getOrDefault(last, 0) + 1);
            s2.put(last, s2.get(last) - 1);
            if (s2.get(last) == 0) {
                s2.remove(last);
            }
            size2--;
            sum2 -= last;
        } else {
            s2.put(del, s2.get(del) - 1);
            if (s2.get(del) == 0) {
                s2.remove(del);
            }
            size2--;
            sum2 -= del;
        }

    }

    public int calculateMKAverage() {
        if (deque.size() < m) {
            return -1;
        }
        return (int) (sum2 / (m - 2 * k));
    }
}
