package com.wgx.fifty.day31;

/**
 * @author wgx
 * @since 2023/3/21 10:36
 */
public class 后继者 {
    public static void main(String[] args) {
        System.out.println(
                inorderSuccessor(
                        new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4)), new TreeNode(8, new TreeNode(7), new TreeNode(9))),
                        new TreeNode(2)
                ).val
        );
    }
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode node =  inorderSuccessor(root.left, p);
        return node == null ? root : node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
