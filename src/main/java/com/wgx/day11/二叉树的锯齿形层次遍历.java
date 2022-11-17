package com.wgx.day11;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/**
 * @author wgx
 * @since 2022/10/29 21:32
 */

public class 二叉树的锯齿形层次遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        //1代表从左到右，-1表示从右到左
        int flag = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (flag > 0) {
                    TreeNode node = deque.pollFirst();
                    row.add(node.val);
                    if (node.left != null)
                        deque.addLast(node.left);
                    if (node.right != null)
                        deque.addLast(node.right);
                } else {
                    TreeNode node = deque.pollLast();
                    row.add(node.val);
                    if (node.right != null)
                        deque.addFirst(node.right);
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                }
            }
            flag = -flag;
            ans.add(row);
        }
        return ans;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
