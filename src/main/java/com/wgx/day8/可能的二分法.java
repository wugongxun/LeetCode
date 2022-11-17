package com.wgx.day8;

import java.util.*;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/16 13:30
 */
public class 可能的二分法 {
    public static void main(String[] args) {
        System.out.println(possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        //从1-n个元素分别在第几组，0表示还未分组，1表示第一组，2表示第二组
        int[] groups = new int[n + 1];
        //1-n个元素不喜欢的人的list
        List<Integer>[] hates = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            hates[i] = new ArrayList<>();
        }
        //根据dislikes初始化hate
        for (int[] dislike : dislikes) {
            hates[dislike[0]].add(dislike[1]);
            hates[dislike[1]].add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            //如果groups[i]为0，分到第一组
            if (groups[i] == 0 && !dfs(i, 1, groups, hates)) {
                //分组失败
                return false;
            }
        }
        //全部分组成功
        return true;
    }

    public static boolean dfs(int i, int group, int[] groups, List<Integer>[] hates) {
        groups[i] = group;
        //遍历i元素所有不喜欢的人
        for (Integer hate : hates[i]) {
            //如果groups[hate]不为0，说明hate已经分好组了，如果是和i一组，说明分组失败
            if (groups[hate] != 0 && groups[hate] == group) {
                return false;
            }
            //如果groups[hate]为0，将hate尝试进行分到另外一组，如果失败直接返回false
            if (groups[hate] == 0 && !dfs(hate, group ^ 3, groups, hates)) {
                return false;
            }
        }
        return true;
    }
}
