package com.wgx.day36;

/**
 * @author wgx
 * @since 2023/4/21 10:06
 *
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class 回文子串 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    //  Manacher 算法

    /**
     * Manacher 算法如何通过已经计算出的状态来更新 f(i) 呢？Manacher 算法要求我们维护「当前最大的回文的右端点 rm」以及这个回文右端点对应的回文中心 im。
     * 我们需要顺序遍历 s，假设当前遍历的下标为 i。我们知道在求解 f(i) 之前我们应当已经得到了从 [1,i−1]所有的 f，并且当前已经有了一个最大回文右端点 rm以及它对应的回文中心 im
     * 初始化 f(i)
     * 如果 i≤rm
     *  说明 i 被包含在当前最大回文子串内，假设 j 是 i 关于这个最大回文的回文中心 im的对称位置（即 j+i=2×im），我们可以得到 f(i) 至少等于 min{f(j),rm−i+1}这里将 f(j) 和 rm−i+1取小，是先要保证这个回文串在当前最大回文串内。（思考：为什么 f(j) 有可能大于 rm−i+1？）
     *
     * 如果 i>rm
     *  那就先初始化 f(i)=1。
     *
     * 中心拓展
     * 做完初始化之后，我们可以保证此时的 s[i+f(i)−1]=s[i−f(i)+1]，要继续拓展这个区间，我们就要继续判断 s[i+f(i)] 和 s[i−f(i)] 是否相等，如果相等将 f(i) 自增；这样循环直到 s[i+f(i)]≠s[i−f(i)]
     * 
     * 以此类推。我们可以看出循环每次结束时都能保证 s[i+f(i)−1]=s[i−f(i)+1]，而循环继续（即可拓展的条件）一定是 s[i+f(i)]=s[i−f(i)]。 这个时候我们需要注意的是不能让下标越界，有一个很简单的办法，就是在开头加一个 $，并在结尾加一个 !，这样开头和结尾的两个字符一定不相等，循环就可以在这里终止。
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int n = s.length();
        var sb = new StringBuilder("^#");
        for (int i = 0; i < n; ++i) {
            sb.append(s.charAt(i));
            sb.append('#');
        }

        n = sb.length();
        sb.append("$");

        var f = new int[n];
        int iMax = 0, rMax = 0, res = 0;
        for (int i = 1; i < n; ++i) {
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            while (sb.charAt(i + f[i]) == sb.charAt(i - f[i])) {
                ++f[i];
            }

            if (i + f[i] - 1 > rMax) {
                rMax = i + f[i] - 1;
                iMax = i;
            }

            res += f[i] / 2;
        }
        return res;
    }

//    public static int countSubstrings(String s) {
//        int n = s.length();
//        var dp = new int[n];
//        dp[0] = 1;
//        var re = new boolean[n][n];
//        for (int i = 0; i < n; i++) {
//            re[i][i] = true;
//        }
//        var chs = s.toCharArray();
//        for (int i = 1; i < n; i++) {
//            int temp = 1;
//            for (int j = 0; j < i; j++) {
//                if (chs[j] == chs[i] && (j + 1 > i - 1 || re[j + 1][i - 1])) {
//                    re[j][i] = true;
//                    temp++;
//                }
//            }
//            dp[i] = dp[i - 1] + temp;
//        }
//        return dp[n - 1];
//    }
}
