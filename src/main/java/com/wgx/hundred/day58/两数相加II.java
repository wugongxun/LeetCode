package com.wgx.hundred.day58;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/7/31 10:48
 */
public class 两数相加II {
    @Test
    public void test() {
        addTwoNumbers(
                new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3)))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        );
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var r1 = reverse(l1);
        var r2 = reverse(l2);

        int carry = 0;
        ListNode res = new ListNode();
        while (r1 != null || r2 != null) {
            int sum = carry;
            if (r1 != null) {
                sum += r1.val;
                r1 = r1.next;
            }
            if (r2 != null) {
                sum += r2.val;
                r2 = r2.next;
            }
            var node = new ListNode(sum % 10);
            node.next = res.next;
            res.next = node;
            carry = sum / 10;
        }

        return res.next;
    }

    public ListNode reverse(ListNode ln) {
        var prev = ln;
        var cur = ln.next;
        prev.next = null;
        while (cur != null) {
            var next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}