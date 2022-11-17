package com.wgx.day3;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/30 10:58
 */
public class 删除链表的倒数第N个节点 {
    public static void main(String[] args) {
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1 && head.next == null) {
            return null;
        }
        findNthFromEnd(head, n);
        return head;
    }

    public static int findNthFromEnd(ListNode node, int n) {
        if (node.next == null)
            return 1;
        int nextNthFromEnd = findNthFromEnd(node.next, n);
        if (n == 1 && nextNthFromEnd == n) {
            node.next = null;
        }
        if (nextNthFromEnd + 1 == n) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        return nextNthFromEnd + 1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void show() {
        this.show(this);
    }

    public void show(ListNode head) {
        System.out.println(head);
        while (head.next != null) {
            System.out.println(head.next);
            head = head.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}