package com.wgx.fifty.day13;

import java.util.Stack;

/**
 * @author wgx
 * @since 2022/12/27 10:18
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */

public class 二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
        //[5,3,6,2,4,null,null,1]
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        System.out.println(kthSmallest(root, 3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if (--k == 0) {
                return temp.val;
            }
            temp = temp.right;
        }
        return 0;
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
