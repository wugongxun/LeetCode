package com.wgx.fifty.day4;

import java.util.HashSet;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/3 15:01
 */
public class 环形链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        System.out.println(hasCycle(head));
    }
    public static boolean hasCycle(ListNode head) {
        if (head == null && head.next == null)
            return true;
        HashSet<ListNode> set = new HashSet();
        set.add(head);
        while (head.next != null) {
            if (!set.add(head.next)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
