package com.wgx.day33;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/3/31 16:28
 */
public class PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.offer(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(4);
        queue.offer(5);
        queue.offer(0);
        queue.offer(10);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private List<Integer> arr;

    public PriorityQueue() {
        this.arr = new ArrayList<>();
    }

    public void offer(int el) {
        arr.add(el);
        int k = arr.size() - 1;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            int p = arr.get(parent);
            if (p <= el)
                break;
            arr.set(k, p);
            k = parent;
        }
        arr.set(k, el);
    }

    public int poll() {
        int res = arr.get(0);
        int k = 0;
        int key = arr.remove(arr.size() - 1);
        int n = arr.size();
        if (n > 0) {
            int half = n >>> 1;
            while (k < half) {
                int child = (k << 1) + 1;
                int c = arr.get(child);
                int right = child + 1;
                if (right < n && c > arr.get(right))
                    c = arr.get((child = right));
                if (key <= c)
                    break;
                arr.set(k, c);
                k  = child;
            }
            arr.set(k, key);
        }
        return res;
    }
}
