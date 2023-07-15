package com.wgx.fifty.day46;

/**
 * @author wgx
 * @since 2023/6/24 18:08
 */
public class 合并K个升序链表 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        System.out.println(mergeKLists(new ListNode[]{
                listNode1, listNode2, listNode3
        }));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        var head = new ListNode(Integer.MAX_VALUE);
        var p = head;
        ListNode minCur = null;
        int minIndex = 0;
        var isNull = new boolean[n];
        int count = 0;
        while (count < n) {
            for (int i = 0; i < n; ++i) {
                var cur = lists[i];
                if (cur == null) {
                    if (!isNull[i]) {
                        isNull[i] = true;
                        ++count;
                    }
                    continue;
                }
                if (minCur == null || cur.val < minCur.val) {
                    minCur = cur;
                    minIndex = i;
                }
            }
            if (minCur != null) {
                p.next = new ListNode(minCur.val);
                lists[minIndex] = lists[minIndex].next;
                p = p.next;
                minCur = null;
            }
        }
        return head.next;
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
