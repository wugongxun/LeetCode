package com.wgx.fifty.day31;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/3/22 9:40
 * <p>
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 * <p>
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 * <p>
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 */
public class 无矛盾的最佳球队 {
    public static void main(String[] args) {
        System.out.println(bestTeamScore(new int[]{9, 2, 8, 8, 2}, new int[]{4, 1, 3, 3, 5}));
    }

    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length, res = 0;
        var p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i] = new int[]{scores[i], ages[i]};
        }

        Arrays.sort(p, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        var dp = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (p[j][1] <= p[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += p[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}
