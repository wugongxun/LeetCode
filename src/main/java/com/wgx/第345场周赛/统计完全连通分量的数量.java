package com.wgx.第345场周赛;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/5/14 11:23
 */
public class 统计完全连通分量的数量 {
    @Test
    public void test() {
        System.out.println(countCompleteComponents(6, new int[][]{
                {0, 1}, {0, 2}, {1, 2}, {3, 4}
        }));
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            var list = new ArrayList<Integer>();
            list.add(i);
            adj[i] = list;
        }
        for (var edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int res = 0;
        var seen = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!seen[i]) {
                if (adj[i].size() == 1) {
                    res++;
                    seen[i] = true;
                    continue;
                }
                boolean flag = true;
                for (var node : adj[i]) {
                    if (node != i && !validate(adj[i], adj[node])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res++;
                    for (var node : adj[i]) {
                        seen[node] = true;
                    }
                }
            }
        }
        return res;
    }

    public boolean validate(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list2.contains(list1.get(i))) {
                return false;
            }
        }
        return true;
    }
}
