package com.wgx.day46;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/6/25 11:27
 */
public class 路径总和III {
    @Test
    public void test() {
//        TreeNode root = new TreeNode(10,
//                new TreeNode(5,
//                        new TreeNode(3,
//                                new TreeNode(3), new TreeNode(-2)
//                        ),
//                        new TreeNode(2,
//                                null, new TreeNode(1)
//                        )
//                )
//                , new TreeNode(-3, null, new TreeNode(11)));
        TreeNode root = new TreeNode(1000000000, new TreeNode(1000000000, new TreeNode(294967296, new TreeNode(1000000000, new TreeNode(1000000000, new TreeNode(1000000000), null), null), null), null), null);
        System.out.println(pathSum(root, 8));
    }

    int targetSum;
    int res;

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        res = 0;
        var prefix = new ArrayList<Integer>();
        prefix.add(0);
        dfs(root, prefix);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> prefix) {
        if (node == null) {
            return;
        }
        int cur = node.val + prefix.get(prefix.size() - 1);
        for (var pre : prefix) {
            if (cur - pre == targetSum) {
                res++;
            }
        }
        prefix.add(cur);
        dfs(node.left, prefix);
        dfs(node.right, prefix);
        prefix.remove(prefix.size() - 1);
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

