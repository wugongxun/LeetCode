package com.wgx.day35;

/**
 * @author wgx
 * @since 2023/4/18 10:19
 */
public class 节点与其祖先之间的最大差值 {
    public static void main(String[] args) {

    }

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode node, int max, int min) {
        if (node == null) {
            return 0;
        }

        int diff = Math.max(Math.abs(node.val - max), Math.abs(node.val - min));
        max = Math.max(node.val, max);
        min = Math.min(node.val, min);
        diff = Math.max(diff, dfs(node.left, max, min));
        diff = Math.max(diff, dfs(node.right, max, min));
        return diff;
    }


}
