package com.wgx.day6;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/9 10:18
 */
public class 最小栈 {
    public static void main(String[] args) {

    }
}
class MinStack {
    private ListNode head;

    public MinStack() {
    }

    public void push(int val) {
        if (isEmpty()) {
            head = new ListNode(val, val, null);
        } else {
            head = new ListNode(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
class ListNode {
    public int val;
    public int min;
    public ListNode next;

    public ListNode(int val, int min, ListNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}