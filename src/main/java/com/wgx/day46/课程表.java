package com.wgx.day46;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgx
 * @since 2023/6/26 11:46
 */
public class 课程表 {
    @Test
    public void test() {
        System.out.println(canFinish(2, new int[][]{
                {1, 0}, {0, 1}
        }));
    }

    List<Integer>[] adj;
    //表示搜索状态，0表示未搜索，1表示搜索中，2表示搜索完成
    int[] visited;
    //是否有环
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new List[numCourses];
        Arrays.setAll(adj, i -> new ArrayList<>());
        visited = new int[numCourses];
        for (var prerequisite : prerequisites) {
            adj[prerequisite[1]].add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int i) {
        //标记为搜索中
        visited[i] = 1;
        for (var next : adj[i]) {
            if (visited[next] == 0) {
                dfs(next);
                if (!valid) {
                    return;
                }
            } else if (visited[next] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }
}
