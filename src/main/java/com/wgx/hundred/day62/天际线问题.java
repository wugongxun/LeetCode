package com.wgx.hundred.day62;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wgx
 * @since 2023/8/22 15:29
 */
public class 天际线问题 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        var segmentTree = new SegmentTree(0, Integer.MAX_VALUE - 1);
        Arrays.sort(buildings, Comparator.comparingInt(i -> i[2]));
        for (var building : buildings) {
            segmentTree.update(building[0], building[1] - 1, building[2]);
        }
        var skyLine = segmentTree.values();
        skyLine.add(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 0});
        int last = 0;
        var res = new ArrayList<List<Integer>>();
        for (var arr : skyLine) {
            if (arr[2] != last) {
                res.add(List.of(arr[0], arr[2]));
                last = arr[2];
            }
        }
        return res;
    }
}


class SegmentTree {
    public static class Node {
        int val;
        int lazy;
        Node left;
        Node right;
    }

    private final Node root;
    private final int L_LIMIT, R_LIMIT;

    public SegmentTree(int l_LIMIT, int r_LIMIT) {
        root = new Node();
        L_LIMIT = l_LIMIT;
        R_LIMIT = r_LIMIT;
    }

    public void update(int L, int R, int val) {
        update(root, L_LIMIT, R_LIMIT, L, R, val);
    }

    public void update(Node node, int l, int r, int L, int R, int val) {
        if (L > r || R < l)
            return;
        if (L <= l && R >= r) {
            node.val = val;
            node.lazy = val;
            return;
        }
        if (node.left == null)
            node.left = new Node();
        if (node.right == null)
            node.right = new Node();
        if (node.lazy != 0)
            pushDownLazy(node);

        int m = (r - l) / 2 + l;
        update(node.left, l, m, L, R, val);
        update(node.right, m + 1, r, L, R, val);
    }

    public void pushDownLazy(Node node) {
        node.left.val = node.lazy;
        node.left.lazy = node.lazy;
        node.right.val = node.lazy;
        node.right.lazy = node.lazy;
        node.lazy = 0;
    }

    public List<int[]> values() {
        var skyLine = new ArrayList<int[]>();
        values(root, L_LIMIT, R_LIMIT, skyLine);
        return skyLine;
    }

    public void values(Node node, int l, int r, List<int[]> skyLine) {
        if (node == null || node.left == null || node.right == null) {
            skyLine.add(new int[]{l, r, node == null ? 0 : node.val});
            return;
        }
        if (l != r && node.lazy != 0)
            pushDownLazy(node);
        int m = (r - l) / 2 + l;
        values(node.left, l, m, skyLine);
        values(node.right, m + 1, r, skyLine);
    }
}
