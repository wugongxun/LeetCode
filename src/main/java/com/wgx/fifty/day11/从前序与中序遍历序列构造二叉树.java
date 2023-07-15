package com.wgx.fifty.day11;

import java.util.Stack;

/**
 * @author wgx
 * @since 2022/10/30 16:18
 *
 * [3,9,20,15,7]
 * [9,3,15,20,7]
 */
public class 从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        for (int i = 1, j = 0; i < preorder.length; i++) {
            if (cur.val != inorder[j]) {
                cur.left = new TreeNode(preorder[i]);
                stack.push(cur);
                cur = cur.left;
            } else {
                j++;
                while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    cur = stack.pop();
                    j++;
                }
                cur = cur.right = new TreeNode(preorder[i]);
            }
        }
        return root;


        /*if (preorder.length == 1 || inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        List<Integer> inLeftList = new ArrayList<>();
        List<Integer> preLeftList = new ArrayList<>();
        List<Integer> inRightList = new ArrayList<>();
        List<Integer> preRightList = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                flag = true;
                continue;
            }
            if (flag) {
                inRightList.add(inorder[i]);
            } else {
                inLeftList.add(inorder[i]);
            }
        }
        int count = inLeftList.size();
        for (int i = 1; i < preorder.length; i++, count--) {
            if (count > 0) {
                preLeftList.add(preorder[i]);
            } else {
                preRightList.add(preorder[i]);
            }
        }
        TreeNode leftTree = buildTree(preLeftList.stream().mapToInt(Integer::intValue).toArray(), inLeftList.stream().mapToInt(Integer::intValue).toArray());
        TreeNode rightTree = buildTree(preRightList.stream().mapToInt(Integer::intValue).toArray(), inRightList.stream().mapToInt(Integer::intValue).toArray());
        root.left = leftTree;
        root.right = rightTree;
        return root;*/
    }
}
