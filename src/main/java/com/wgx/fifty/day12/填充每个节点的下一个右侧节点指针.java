package com.wgx.fifty.day12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wgx
 * @since 2022/11/23 10:49
 */
public class 填充每个节点的下一个右侧节点指针 {
    public static void main(String[] args) {

    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = deque.removeFirst();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                if (node.left != null && node.right != null) {
                    deque.addLast(node.left);
                    deque.addLast(node.right);
                }
            }
        }
        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};