package com.wgx.day49;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wgx
 * @since 2023/7/13 11:30
 */
public class 数据流的中位数 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;

    public MedianFinder() {
        small = new PriorityQueue<>(Comparator.reverseOrder());
        big = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.isEmpty()) {
            small.offer(num);
            return;
        }
        int mid = small.peek();
        if (num <= mid) {
            small.offer(num);
            while (small.size() - big.size() > 1) {
                big.offer(small.poll());
            }
        } else if (num > mid) {
            big.offer(num);
            while (big.size()  > small.size()) {
                small.offer(big.poll());
            }
        }
    }

    public double findMedian() {
        if (small.size() == big.size()) {
            return (small.peek() + big.peek()) / 2d;
        } else {
            return small.peek();
        }
    }
}