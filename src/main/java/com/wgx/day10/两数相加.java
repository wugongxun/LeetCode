package com.wgx.day10;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/23 18:22
 */
public class 两数相加 {
    public static void main(String[] args) {
        ListNode res = addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9))), new ListNode(9, new ListNode(9, new ListNode(9))));
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        addTwoNumbers(l1, l2, res, 0);
        return res.next;
    }

    public static void addTwoNumbers(ListNode l1, ListNode l2, ListNode res, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            res = null;
            return;
        }
        int val1 = 0;
        int val2 = 0;
        if (l1 != null) {
            val1 = l1.val;
        }
        if (l2 != null) {
            val2 = l2.val;
        }
        res.next = new ListNode((val1 + val2 + carry) % 10);
        addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, res.next, (val1 + val2 + carry) / 10);
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
