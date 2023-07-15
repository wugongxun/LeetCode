package com.wgx.fifty.day45;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author wgx
 * @since 2023/6/20 10:06
 */
public class 排序链表 {
    @Test
    public void test() {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5)))));
        System.out.println(sortList(head).val);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        var end = head;
        while (end.next != null) {
            end = end.next;
        }
        divide(head, end);
        return head;
    }

    public void divide(ListNode left, ListNode right) {
        if (left == right || left.next == right) {
            if (left.val > right.val) {
                left.val ^= right.val;
                right.val ^= left.val;
                left.val ^= right.val;
            }
            return;
        }
        var slow = left;
        var fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        divide(left, slow);
        divide(slow, right);
        sort(left, slow, right);
    }

    public void sort(ListNode left, ListNode mid, ListNode right) {
        var i = left;
        var j = mid;
        var list = new ArrayList<Integer>();
        while (i != mid && j != right.next) {
            if (i.val < j.val) {
                list.add(i.val);
                i = i.next;
            } else {
                list.add(j.val);
                j = j.next;
            }
        }

        while (i != mid) {
            list.add(i.val);
            i = i.next;
        }

        while (j != right.next) {
            list.add(j.val);
            j = j.next;
        }

        var cur = left;
        int index = 0;
        while (cur != right.next) {
            cur.val = list.get(index);
            cur = cur.next;
            index++;
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