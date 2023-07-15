package com.wgx.fifty.day37;

import java.util.*;

/**
 * @author wgx
 * @since 2023/4/28 10:24
 */
public class 餐盘栈 {
    public static void main(String[] args) {
        DinnerPlates dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.push(3);
        dinnerPlates.push(4);
        dinnerPlates.push(5);
        dinnerPlates.popAtStack(0);
        dinnerPlates.push(20);
        dinnerPlates.push(21);
        dinnerPlates.popAtStack(0);
        dinnerPlates.popAtStack(2);
        dinnerPlates.pop();
        dinnerPlates.pop();
        dinnerPlates.pop();
        dinnerPlates.pop();
        dinnerPlates.pop();
    }
}
class DinnerPlates {
    int capacity;
    List<Stack<Integer>> stacks;
    PriorityQueue<Integer> queue;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
        this.queue = new PriorityQueue<>();
    }

    public void push(int val) {
        if (!queue.isEmpty() && queue.peek() >= stacks.size()) {
            queue.clear();
        }
        if (queue.isEmpty()) {
            var stack = new Stack<Integer>();
            stack.push(val);
            stacks.add(stack);
            if (capacity > 1) {
                queue.add(stacks.size() - 1);
            }
        } else {
            var stack = stacks.get(queue.peek());
            stack.push(val);
            if (stack.size() == capacity) {
                queue.poll();
            }
        }
    }

    public int pop() {
        return popAtStack(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= stacks.size() ||stacks.get(index).isEmpty()) {
            return -1;
        }
        var stack = stacks.get(index);
        if (stack.size() == capacity) {
            queue.add(index);
        }
        int val = stack.pop();
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return val;
    }
}