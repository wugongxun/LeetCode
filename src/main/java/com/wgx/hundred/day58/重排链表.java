package com.wgx.hundred.day58;

/**
 * @author wgx
 * @since 2023/7/31 9:17
 */
public class 重排链表 {
    public static void main(String[] args) {
        reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        //先找到中间节点
        var slow = head;
        var fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        //反转后半段链表
        var prev = slow.next;
        var reverse = prev.next;
        slow.next = null;
        prev.next = null;
        while (reverse != null) {
            var next = reverse.next;
            reverse.next = prev;
            prev = reverse;
            reverse = next;
        }

        //重新排序
        var cur = head;
        reverse = prev;
        while (reverse != null && cur != null) {
            var curNext = cur.next;
            var reverseNext = reverse.next;
            cur.next = reverse;
            reverse.next = curNext;
            cur = curNext;
            reverse = reverseNext;
        }
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