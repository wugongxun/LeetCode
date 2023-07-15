package com.wgx.fifty.day4;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/5 16:46
 */
public class 将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }
}
