package com.wgx.hundred.day53;

/**
 * @author wgx
 * @since 2023/7/19 16:40
 */
public class 删除二叉搜索树中的节点 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
//        System.out.println(deleteNode(root, 3));
//        TreeNode root = new TreeNode(4, null, new TreeNode(7, new TreeNode(6, new TreeNode(5), null), new TreeNode(8, new TreeNode(9), null)));
//        System.out.println(deleteNode(root, 7));
        TreeNode root = new TreeNode(10, new TreeNode(5, null, new TreeNode(7)), null);
        System.out.println(deleteNode(root, 10));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            var temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            root.right = deleteNode(root.right, temp.val);
            root.val = temp.val;
            return root;
        }
        return root;
    }

//    public static TreeNode deleteNode(TreeNode root, int key) {
//        var cur = root;
//        TreeNode fa = null;
//        while (cur != null) {
//            if (cur.val == key) {
//                if (cur.left == null && cur.right == null) {
//                    //删除的节点为叶子节点
//                    if (fa == null) {
//                        //并且删除节点为父节点
//                        root = null;
//                    } else {
//                        //普通叶子节点
//                        if (fa.left == cur) {
//                            fa.left = null;
//                        } else {
//                            fa.right = null;
//                        }
//                    }
//                    break;
//                } else if (cur.left != null && cur.right != null) {
//                    //删除的节点为非叶子节点，并且有两颗子树
//                    var temp = cur.left;
//                    int maxVal = temp.val;
//                    while (temp.right != null) {
//                        temp = temp.right;
//                        if (temp.val > maxVal) {
//                            maxVal = temp.val;
//                        }
//                    }
//                    deleteNode(cur, maxVal);
//                    cur.val = maxVal;
//                    break;
//                } else {
//                    //删除的节点为非叶子节点，并且只有一颗子树
//                    if (fa == null) {
//                        if (root.left != null) {
//                            var temp = root.left;
//                            int maxVal = temp.val;
//                            while (temp.right != null) {
//                                temp = temp.right;
//                                maxVal = temp.val;
//                            }
//                            deleteNode(root, maxVal);
//                            root.val = maxVal;
//                        } else {
//                            var temp = root.right;
//                            int minVal = temp.val;
//                            while (temp.left != null) {
//                                temp = temp.left;
//                                minVal = temp.val;
//                            }
//                            deleteNode(root, minVal);
//                            root.val = minVal;
//                        }
//                        break;
//                    }
//                    if (cur.left != null) {
//                        if (fa.left == cur) {
//                            fa.left = cur.left;
//                        } else {
//                            fa.right = cur.left;
//                        }
//                    } else {
//                        if (fa.left == cur) {
//                            fa.left = cur.right;
//                        } else {
//                            fa.right = cur.right;
//                        }
//                    }
//                    break;
//                }
//            } else if (cur.val < key) {
//                fa = cur;
//                cur = cur.right;
//            } else {
//                fa = cur;
//                cur = cur.left;
//            }
//        }
//        return root;
//    }
}
