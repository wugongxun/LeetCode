package com.wgx.fifty.day34;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/4/15 13:29
 */
public class 不邻接植花 {
    public static void main(String[] args) {

    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] adj = new List[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (var path : paths) {
            adj[path[0] - 1].add(path[1] - 1);
            adj[path[1] - 1].add(path[0] - 1);
        }

        var res = new int[n];
        for (int i = 0; i < n; ++i) {
            var list = adj[i];
            var used = new ArrayList<Integer>();
            for (var num : list) {
                if (res[num] != 0) {
                    used.add(res[num]);
                }
            }
            for (int j = 1; j < 5; ++j) {
                if (!used.contains(j)) {
                    res[i] = j;
                    break;
                }
            }
        }

        return res;

    }
}