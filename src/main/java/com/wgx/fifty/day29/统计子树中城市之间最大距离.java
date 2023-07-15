package com.wgx.fifty.day29;

import java.util.*;

/**
 * @author wgx
 * @since 2023/3/12 13:25
 */
public class 统计子树中城市之间最大距离 {
    public static void main(String[] args) {

    }

    int mask, vis, diameter;
    List<Integer>[] adj;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        Arrays.setAll(adj, i -> new ArrayList());

        for (var edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            adj[x].add(y);
            adj[y].add(x);
        }

        var res = new int[n - 1];
        for (mask = 3; mask < 1 << n; mask++) {
            if ((mask & mask - 1) == 0) continue;//至少需要两个点

            vis = diameter = 0;
            dfs(Integer.numberOfTrailingZeros(mask));
            if (vis == mask) {
                ++res[diameter - 1];
            }
        }
        return res;
    }

    public int dfs(int x) {
        vis |= 1 << x;
        int maxLen = 0;
        for (var y : adj[x]) {
            if ((vis >> y & 1) == 0 && (mask >> y & 1) == 1) {
                int ml = dfs(y) + 1;
                diameter = Math.max(diameter, maxLen + ml);
                maxLen = Math.max(maxLen, ml);
            }
        }
        return maxLen;
    }
}
