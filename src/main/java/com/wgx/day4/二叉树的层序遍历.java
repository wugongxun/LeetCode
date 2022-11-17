package com.wgx.day4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/5 15:54
 */
public class 二叉树的层序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> order = levelOrder(root);
        System.out.println(order);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int layerNum = queue.size();
            ArrayList<Integer> layerList = new ArrayList<>();
            for (int i = 0; i < layerNum; i++) {
                TreeNode node = queue.poll();
                layerList.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(layerList);
        }
        return res;




//        List<Integer> first = new ArrayList<>();
//        first.add(root.val);
//        res.add(0, first);
//        if (root.left == null && root.right == null)
//            return res;
//        List<Integer> second = new ArrayList<>();
//        res.add(1, second);
//        if (root.left != null) {
//            second.add(root.left.val);
//            levelOrder(root.left, 2);
//        }
//        if (root.right != null) {
//            second.add(root.right.val);
//            levelOrder(root.right, 2);
//        }
//        return res;
    }
    
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> levelOrder(TreeNode root, int layer) {
        if (root.left != null) {
            if (res.size() < layer + 1) {
                res.add(layer, new ArrayList<>());
            }
            res.get(layer).add(root.left.val);
            levelOrder(root.left, layer + 1);
        }
        if (root.right != null) {
            if (res.size() < layer + 1) {
                res.add(layer, new ArrayList<>());
            }
            res.get(layer).add(root.right.val);
            levelOrder(root.right, layer + 1);
        }
        return res;
    }
}
