package com.wgx.fifty.day19;

/**
 * @author wgx
 * @since 2023/1/30 9:41
 */

public class 合并两个链表 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        ListNode list2 = new ListNode(1000000, new ListNode(1000001, new ListNode(1000002)));
        mergeInBetween(list1, 3, 4, list2);
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = 0;
        ListNode temp = list1;
        ListNode aPre = null;
        ListNode bNext = null;
        ListNode list2End = list2;
        while (list2End.next != null) {
            list2End = list2End.next;
        }
        while (true) {
            if (index == a - 1) {
                aPre = temp;
            }
            if (index == b) {
                bNext = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
            index++;
        }
        aPre.next = list2;
        list2End.next = bNext;
        return list1;
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
