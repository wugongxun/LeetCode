package com.wgx.fifty.day50;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/7/14 14:39
 */
public class 在二叉树中分配硬币 {
    @Test
    public void test() {
        System.out.println(distributeCoins(new TreeNode(3, new TreeNode(0), new TreeNode(0))));
    }

    public int distributeCoins(TreeNode root) {
        return postOrder(root)[1];
    }

    public int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        var left = postOrder(node.left);
        var right = postOrder(node.right);
        int cur = node.val + left[0] + right[0];
        int step = left[1] + right[1];
        return new int[]{cur - 1, step + Math.abs(cur - 1)};
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
