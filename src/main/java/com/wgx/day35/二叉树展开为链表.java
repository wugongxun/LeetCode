package com.wgx.day35;

/**
 * @author wgx
 * @since 2023/4/17 10:55
 */
public class 二叉树展开为链表 {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);

        TreeNode right = root.right;

        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        flatten(right);
        root.right = right;
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
