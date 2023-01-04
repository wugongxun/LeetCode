package com.wgx.day13;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author wgx
 * @since 2022/12/30 9:57
 */
public class 考场就座 {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(4);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(1);
        examRoom.leave(3);
        System.out.println(examRoom.seat());
    }
}
class ExamRoom {
    int n;
    TreeSet<Integer> seats;
    PriorityQueue<int[]> pq;

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<>();
        this.pq = new PriorityQueue<>(n, (a, b) -> {
            int d1 = a[1] - a[0], d2 = b[1] - b[0];
            //区间1的长度大于区间2的长度，区间1为优先
            //区间1的长度等于区间2的长度，但是a[0] < b[0]
            return d1 / 2 > d2 / 2 || (d1 / 2 == d2 / 2 && a[0] < b[0]) ? -1 : 1;
        });
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        //left为第一个有人的位置到最左座位的距离，right为最后一个有人的位置到最右座位的距离
        int left = seats.first(), right = n - 1 - seats.last();
        while (seats.size() >= 2) {
            int[] p = pq.peek();
            if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) {
                int d = p[1] - p[0];
                //判断seat这个座位是否要优于最左座位和最右座位
                if (d / 2 <= left || d / 2 < right) {
                    break;
                }
                int seat = p[0] + d / 2;
                pq.poll();
                pq.offer(new int[]{p[0],seat});
                pq.offer(new int[]{seat, p[1]});
                seats.add(seat);
                return seat;
            }
            pq.poll();//延迟删除
        }
        //最左座位或者最右座位为最优
        if (right > left) {
            //最右座位为最优
            pq.offer(new int[]{seats.last(), n - 1});
            seats.add(n - 1);
            return n - 1;
        } else {
            //最左座位为最优
            pq.offer(new int[]{0, seats.first()});
            seats.add(0);
            return 0;
        }
    }

    public void leave(int p) {
        if (p != seats.first() && p != seats.last()) {
            pq.offer(new int[]{seats.lower(p), seats.higher(p)});
        }
        seats.remove(p);
    }
}