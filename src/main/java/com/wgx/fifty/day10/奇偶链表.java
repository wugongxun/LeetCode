package com.wgx.fifty.day10;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/24 11:41
 */
public class 奇偶链表 {
    public static void main(String[] args) {
        ListNode res = oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastOdd = head;
        ListNode lastEven = head.next;
        ListNode even = head.next;
        ListNode temp = head.next.next;
        int count = 3;
        while (temp != null) {
            if ((count & 1) == 1) {
                lastOdd.next = temp;
                lastOdd = temp;
            } else {
                lastEven.next = temp;
                lastEven = temp;
            }
            count++;
            temp = temp.next;
        }
        lastOdd.next = even;
        lastEven.next = null;
        return head;
    }
}
