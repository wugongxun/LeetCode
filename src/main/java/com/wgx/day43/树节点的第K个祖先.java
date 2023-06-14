package com.wgx.day43;

/**
 * @author wgx
 * @since 2023/6/12 9:40
 */
public class 树节点的第K个祖先 {
    public static void main(String[] args) {
        var treeAncestor = new TreeAncestor(5, new int[]{-1, 0, 0, 0, 3});
        System.out.println(treeAncestor.getKthAncestor(1, 5));
        System.out.println(treeAncestor.getKthAncestor(3, 2));
        System.out.println(treeAncestor.getKthAncestor(0, 1));
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(3, 5));
    }
}

class TreeAncestor {
    int[][] parents;

    public TreeAncestor(int n, int[] parent) {
        int m = 32 - Integer.numberOfLeadingZeros(n);
        parents = new int[n][m];
        for (int i = 0; i < n; ++i) {
            parents[i][0] = parent[i];
        }
        for (int i = 0; i < m - 1; ++i) {
            for (int j = 0; j < n; ++j) {
                int p = parents[j][i];
                parents[j][i + 1] = p == -1 ? -1 : parents[p][i];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int m = 32 - Integer.numberOfLeadingZeros(k);
        for (int i = 0; i < m; ++i) {
            if ((k >> i & 1) == 1) {
                node = parents[node][i];
                if (node == -1) {
                    break;
                }
            }
        }
        return node;
    }
}
