package com.wgx.fifty.day45;

/**
 * @author wgx
 * @since 2023/6/17 22:20
 */
public class 复制带随机指针的链表 {
    public static void main(String[] args) {

    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        for (var node = head; node != null; node = node.next.next) {
            var newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        for (var node = head; node != null; node = node.next.next) {
            var newNode = node.next;
            newNode.random = node.random == null ? null : node.random.next;
        }

        var res = head.next;
        for (var node = head; node != null; node = node.next) {
            var newNode = node.next;
            node.next = node.next.next;
            newNode.next = newNode.next == null ? null : newNode.next.next;
        }
        return res;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}