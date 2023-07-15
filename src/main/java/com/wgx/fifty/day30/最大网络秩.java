package com.wgx.fifty.day30;

import java.util.ArrayList;

/**
 * @author wgx
 * @since 2023/3/15 10:41
 */
public class 最大网络秩 {
    public static void main(String[] args) {
        System.out.println(maximalNetworkRank(5, new int[][]{
                {0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}
        }));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        var connect = new boolean[n][n];
        var degree = new int[n];

        for (int i = 0; i < roads.length; ++i) {
            var x = roads[i][0];
            var y = roads[i][1];
            connect[x][y] = true;
            connect[y][x] = true;
            degree[x]++;
            degree[y]++;
        }

        int first = -1, second = -2;
        var firstList = new ArrayList<Integer>();
        var secondList = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] > first) {
                secondList = new ArrayList<>(firstList);
                second = first;
                first = degree[i];
                firstList.clear();
                firstList.add(i);
            } else if (degree[i] == first) {
                firstList.add(i);
            } else if (degree[i] > second) {
                second = degree[i];
                secondList.clear();
                secondList.add(i);
            } else if (degree[i] == second) {
                secondList.add(i);
            }
        }

        if (firstList.size() == 1) {
            Integer f = firstList.get(0);
            for (Integer s : secondList) {
                if (!connect[f][s]) {
                    return first + second;
                }
            }
            return first + second - 1;
        } else {
            for (int i = 0; i < firstList.size(); i++) {
                for (int j = i + 1; j < firstList.size(); j++) {
                    if (!connect[firstList.get(i)][firstList.get(j)]) {
                        return first * 2;
                    }
                }
            }
            return first * 2 - 1;
        }

    }
}
