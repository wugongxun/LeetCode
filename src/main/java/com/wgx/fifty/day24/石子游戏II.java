package com.wgx.fifty.day24;

/**
 * @author wgx
 * @since 2023/2/22 9:24
 * <p>
 * 爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 * <p>
 * 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。
 * <p>
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 * <p>
 * 游戏一直持续到所有石子都被拿走。
 * <p>
 * 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。
 */
public class 石子游戏II {
    public static void main(String[] args) {
        System.out.println(stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }


    //动态规划
    public static int stoneGameII(int[] piles) {
        int s = 0, len = piles.length;

        var dp = new int[len][len + 1];

        for (int i = len - 1; i >= 0; i--) {
            //后缀和
            s += piles[i];
            //极端情况下，每次每个人都拿2 * m个，m最大为(i + 2) / 2，所以m <= i / 2 + 1
            for (int m = 1; m <= i / 2 + 1; m++) {
                if (i + 2 * m >= len) {
                    dp[i][m] = s;
                } else {
                    //从i，m开始拿，让另一个人最佳情况下拿到最少
                    int minAnother = Integer.MAX_VALUE;
                    for (int j = 1; j <= 2 * m; j++) {
                        minAnother = Math.min(minAnother, dp[i + j][Math.max(m, j)]);
                    }
                    dp[i][m] = s - minAnother;
                }
            }
        }
        return dp[0][1];
    }


    //dfs+记忆化搜索
//    public static int stoneGameII(int[] piles) {
//        int len = piles.length;
//        //后缀和
//        for (int i = len - 2; i >= 0; i--) {
//            piles[i] += piles[i + 1];
//        }
//        var cache = new int[len - 1][(len + 1) / 4 + 1];
//        for (int i = 0; i < len - 1; i++) {
//            Arrays.fill(cache[i], -1);
//        }
//        return dfs(piles, 0, 1, cache);
//    }

    public static int dfs(int[] s, int i, int m, int[][] cache) {
        if (i + 2 * m >= s.length) {
            return s[i];
        }
        if (cache[i][m] != -1) {
            return cache[i][m];
        }
        int minAnother = Integer.MAX_VALUE;
        for (int j = 1; j <= m * 2; j++) {
            minAnother = Math.min(minAnother, dfs(s, i + j, Math.max(j, m), cache));
        }
        return cache[i][m] = s[i] - minAnother;
    }
}
