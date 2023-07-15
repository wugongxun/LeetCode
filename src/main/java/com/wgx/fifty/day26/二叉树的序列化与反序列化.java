package com.wgx.fifty.day26;

import java.util.LinkedList;

/**
 * @author wgx
 * @since 2023/3/2 10:24
 */
public class 二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        String serialize = serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))));
        System.out.println(serialize);
        System.out.println(deserialize(serialize));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        var deque = new LinkedList<TreeNode>();
        deque.offerLast(root);
        var res = new StringBuilder(root.val + ",");
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                TreeNode left = node.left;
                if (left != null) {
                    deque.offerLast(left);
                    res.append(left.val + ",");
                } else {
                    res.append("null,");
                }
                TreeNode right = node.right;
                if (right != null) {
                    deque.offerLast(right);
                    res.append(right.val + ",");
                } else {
                    res.append("null,");
                }
            }
        }
        return res.substring(0, res.length() - 1);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.isBlank()) {
            return null;
        }
        String[] split = data.split(",");
        var deque = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        deque.offerLast(root);
        int index = 1;
        while (!deque.isEmpty() && index < split.length) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                String left = split[index++];
                if (!"null".equals(left)) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                    node.left = leftNode;
                    deque.offerLast(leftNode);
                }
                String right = split[index++];
                if (!"null".equals(right)) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                    node.right = rightNode;
                    deque.offerLast(rightNode);
                }
            }
        }
        return root;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}