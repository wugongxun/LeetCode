package com.wgx.hundred.day53;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/7/19 15:22
 */
public class 二叉树中的最长交错路径 {
    @Test
    public void test() {
        System.out.println(longestZigZag(new TreeNode(1,
                null,
                new TreeNode(1,
                            new TreeNode(1),
                            new TreeNode(1,
                                    new TreeNode(1,
                                                null,
                                                new TreeNode(1,
                                                            null,
                                                            new TreeNode(1)
                                                        )
                                            ),
                                    new TreeNode(1)
                            )
                        )
        )));
    }

    public int longestZigZag(TreeNode root) {
        return dfs(root, -1, 0);
    }

    public int dfs(TreeNode node, int dir, int step) {
        if (node == null) {
            return step - 1;
        }
        int res = 0;
        res = Math.max(res, dfs(node.left, 0, dir == 0 ? 0 : step + 1));
        res = Math.max(res, dfs(node.right, 1, dir == 1 ? 0 : step + 1));
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
