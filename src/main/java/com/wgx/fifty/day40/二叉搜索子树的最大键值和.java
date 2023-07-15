package com.wgx.fifty.day40;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/5/20 15:43
 */
public class 二叉搜索子树的最大键值和 {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4, new TreeNode(2), new TreeNode(4));
        root.right = new TreeNode(3, new TreeNode(2), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
        System.out.println(maxSumBST(root));
    }

    int ans = Integer.MIN_VALUE;

    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return ans;
    }

    //res[0]为是否为二叉搜索树，res[1]为最小值，res[2]为最大值，res[3]为和
    public int[] postOrder(TreeNode node) {
        int[] left = null;
        int[] right = null;
        if (node.left != null) {
            left = postOrder(node.left);
        }
        if (node.right != null) {
            right = postOrder(node.right);
        }
        var res = new int[]{1, node.val, node.val, node.val};
        if (left != null) {
            res[0] &= left[0] == 1 && node.val > left[2] ? 1 : 0;
            res[1] = Math.min(res[1], left[1]);
            res[2] = Math.max(res[2], left[2]);
            res[3] = res[3] + left[3];
        }
        if (right != null) {
            res[0] &= right[0] == 1 && node.val < right[1] ? 1 : 0;
            res[1] = Math.min(res[1], right[1]);
            res[2] = Math.max(res[2], right[2]);
            res[3] = res[3] + right[3];
        }
        if (res[0] == 1) {
            ans = Math.max(ans, res[3]);
        }
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
