package com.wgx.hundred.day68;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author wgx
 * @since 2024/7/13 下午3:24
 */
public class 感染二叉树需要的总时间 {

    @Test
    public void test() {
        System.out.println(amountOfTime(new TreeNode(1), 1));
    }

    int start;
    TreeNode startNode;
    HashMap<TreeNode, TreeNode> fa;

    int amountOfTime(TreeNode root, int start) {
        this.start = start;
        fa = new HashMap<>();
        dfs(root, null);
        return maxDepth(startNode, startNode);
    }

    void dfs(TreeNode node, TreeNode from) {
        if (node == null)
            return;
        fa.put(node, from);
        if (node.val == start)
            startNode = node;
        dfs(node.left, node);
        dfs(node.right, node);
    }

    int maxDepth(TreeNode node, TreeNode from) {
        if (node == null)
            return -1;
        int res = -1;
        if (node.left != from) {
            res = Math.max(res, maxDepth(node.left, node));
        }
        if (node.right != from) {
            res = Math.max(res, maxDepth(node.right, node));
        }
        if (fa.containsKey(node) && fa.get(node) != from) {
            res = Math.max(res, maxDepth(fa.get(node), node));
        }
        return res + 1;
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
