package com.wgx.fifty.day34;

/**
 * @author wgx
 * @since 2023/4/16 13:59
 */
public class 打家劫舍III {
    public static void main(String[] args) {
        System.out.println(rob(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)))));
    }

    public static int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }

    //int[0]为不选的情况，int[1]为选的情况
    public static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        var left = dfs(root.left);
        var right = dfs(root.right);
        //当前根节点选择，则当前根节点的子节点都不能选择
        int select = root.val + left[0] + right[0];
        //当前根节点不选，则左右子节点可能选，也可能不选
        int noSelect = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{noSelect, select};
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