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
        var head = new ListNode();
        var cur = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            carry += l1 == null ? 0 : l1.val;
            carry += l2 == null ? 0 : l2.val;
            cur.next = new ListNode(carry % 10);
            carry /= 10;
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head.next;
    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode res = new ListNode();
//        addTwoNumbers(l1, l2, res, 0);
//        return res.next;
//    }
//
//    public static void addTwoNumbers(ListNode l1, ListNode l2, ListNode res, int carry) {
//        if (l1 == null && l2 == null && carry == 0) {
//            return;
//        }
//        int val1 = l1 != null ? l1.val : 0;
//        int val2 = l2 != null ? l2.val : 0;
//        res.next = new ListNode((val1 + val2 + carry) % 10);
//        addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, res.next, (val1 + val2 + carry) / 10);
//    }
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
