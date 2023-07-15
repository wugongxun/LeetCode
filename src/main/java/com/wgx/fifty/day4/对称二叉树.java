package com.wgx.fifty.day4;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/4 15:51
 */
public class 对称二叉树 {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode tree2 = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode root = new TreeNode(1, tree1, tree2);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        if (root.left != null && root.right != null) {
            if (isSymmetric(root.left, root.right))
                return true;
        }
        return false;
    }
    public static boolean isSymmetric(TreeNode tree1, TreeNode tree2) {
        if (tree1.val != tree2.val)
            return false;
        if (tree1.left != null && tree2.right == null)
            return false;
        if (tree1.left == null && tree2.right != null)
            return false;
        if (tree1.right != null && tree2.left == null)
            return false;
        if (tree1.right == null && tree2.left != null)
            return false;
        if (tree1.left != null && tree2.right != null) {
            if (!isSymmetric(tree1.left, tree2.right))
                return false;
        }
        if (tree1.right != null && tree2.left != null) {
            if (!isSymmetric(tree1.right, tree2.left))
                return false;
        }
        return true;
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