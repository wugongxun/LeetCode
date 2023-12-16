package com.wgx.hundred.day64;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/11/25 12:25
 */
public class 二叉树中的伪回文路径 {
    @Test
    public void test() {
        TreeNode root = new TreeNode(2, new TreeNode(3, new TreeNode(3), new TreeNode(1)), new TreeNode(1, null, new TreeNode(1)));
        System.out.println(pseudoPalindromicPaths(root));
    }

    int[] count = new int[10];

    public int pseudoPalindromicPaths(TreeNode root) {
        count[root.val] ^= 1;
        int res = 0;
        if (root.left == null && root.right == null)
            res += Arrays.stream(count).sum() <= 1 ? 1 : 0;
        if (root.left != null)
            res += pseudoPalindromicPaths(root.left);
        if (root.right != null)
            res += pseudoPalindromicPaths(root.right);
        count[root.val] ^= 1;
        return res;
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
