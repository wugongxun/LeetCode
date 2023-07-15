package com.wgx.fifty.day4;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/2 14:55
 */
public class 回文链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        //反转数组
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
