package com.wgx.fifty.day46;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/6/26 10:01
 */
public class 二叉树中的最大路径和 {
    @Test
    public void test() {
//        System.out.println(maxPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
//        System.out.println(maxPathSum(new TreeNode(-3)));
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)), null
                ),
                new TreeNode(8,
                        new TreeNode(13), new TreeNode(4, null, new TreeNode(1))
                )
        );
        System.out.println(maxPathSum(root));
    }

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        int cur = node.val + left + right;
        res = Math.max(res, cur);
        return node.val + Math.max(left, right);
    }
}
