package com.wgx.day44;

/**
 * @author wgx
 * @since 2023/6/17 20:22
 */
public class K个一组翻转链表 {
    public static void main(String[] args) {
        reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        ListNode tail = head;
        ListNode cur;
        ListNode pre = null;
        while ((i < k || k == -1) && head != null) {
            cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
            ++i;
        }
        if (i == k) {
            tail.next = reverseKGroup(head, k);
        } else if (k == -1) {
            return pre;
        } else {
            return reverseKGroup(pre, -1);
        }
        return pre;
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
}