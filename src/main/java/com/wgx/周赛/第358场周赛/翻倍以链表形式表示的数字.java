package com.wgx.周赛.第358场周赛;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/8/13 10:35
 */
public class 翻倍以链表形式表示的数字 {
    @Test
    public void test() {
        System.out.println(doubleIt(new ListNode(5)).val);
    }


    public ListNode doubleIt(ListNode head) {
        if (dfs(head)) {
            var res = new ListNode(1, head);
            return res;
        }
        return head;
    }

    public boolean dfs(ListNode node) {
        if (node == null)
            return false;
        node.val *= 2;
        if (dfs(node.next))
            node.val++;
        var res = node.val >= 10;
        node.val %= 10;
        return res;
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
