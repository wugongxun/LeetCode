package com.wgx.day41;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/5/22 17:38
 */
public class 根到叶路径上的不足节点 {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(-5), null), new TreeNode(-3, new TreeNode(4), null));
        sufficientSubset(root, -1);
    }

    int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        int rootMax = dfs(root, 0, null, -1);
        if (rootMax < limit) {
            return null;
        }
        return root;
    }

    public int dfs(TreeNode node, int sum, TreeNode pre, int dir) {
        if (node.left == null && node.right == null) {
            sum += node.val;
            if (sum < limit && pre != null) {
                if (dir == 0) {
                    pre.left = null;
                } else {
                    pre.right = null;
                }
            }
            return sum;
        }
        sum += node.val;
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        if (node.left != null) {
            left = dfs(node.left, sum, node, 0);
        }
        if (node.right != null) {
            right = dfs(node.right, sum, node, 1);
        }
        int max = Math.max(left, right);
        if (max < limit && pre != null) {
            if (dir == 0) {
                pre.left = null;
            } else {
                pre.right = null;
            }
        }
        return max;
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