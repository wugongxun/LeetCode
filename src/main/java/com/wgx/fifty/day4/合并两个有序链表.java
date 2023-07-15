package com.wgx.fifty.day4;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/2 13:58
 */
public class 合并两个有序链表 {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
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

    public void show() {
        this.show(this);
    }

    public void show(ListNode head) {
        System.out.println(head);
        while (head.next != null) {
            System.out.println(head.next);
            head = head.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}