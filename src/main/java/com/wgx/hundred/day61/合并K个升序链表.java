package com.wgx.hundred.day61;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/8/12 11:23
 */
public class 合并K个升序链表 {
    @Test
    public void test() {
        System.out.println(mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        }));
    }

    int n;
    ListNode[] lists;

    public ListNode mergeKLists(ListNode[] lists) {
        n = lists.length;
        if (n == 0) {
            return null;
        }
        this.lists = lists;
        return divide(0, n - 1);
    }

    public ListNode divide(int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int mid = (l + r) / 2;
        return merge(divide(l, mid), divide(mid + 1, r));
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        var res = new ListNode();
        var cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return res.next;
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
