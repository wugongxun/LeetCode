package com.wgx.day3;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/9/30 11:35
 */
public class 反转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode tail = reverseList(head);
        tail.show();
    }
    public static ListNode reverseList(ListNode curNode) {
        if (curNode == null || curNode.next == null) {
            return curNode;
        }
        ListNode next = curNode.next;
        ListNode tail = reverseList(curNode.next);
        next.next = curNode;
        curNode.next = null;
        return tail;
    }
}
