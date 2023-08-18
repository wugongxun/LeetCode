package com.wgx.笔试.华为OD;

/**
 * @author wgx
 * @since 2023/7/30 10:39
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 * <p>
 * 示例1：
 * 输入：strs=["flower","flow","flight"]
 * 输出："fl"
 * 示例2：
 * <p>
 * 输入：strs=["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 提示：
 * 1<=strs.length<=200
 * 0<=strs[i].length<=200
 * strs[i]仅由小写英文字母组成
 * <p>
 * classSolution{
 * public static String longestCommonPrefix(String[] strs){
 * }
 * }
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
//        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }

        int l = 0, r = minLen;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            var flag = true;
            var prefix = strs[0].substring(0, mid);
            for (int i = 1; i < n; i++) {
                if (!flag)
                    break;
                for (int j = 0; j < mid; j++) {
                    if (strs[i].charAt(j) != prefix.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return strs[0].substring(0, l);
    }

//    public static String longestCommonPrefix(String[] strs) {
//        int n = strs.length;
//        var dp = new String[n];
//        dp[0] = strs[0];
//        for (int i = 1; i < n; i++) {
//            var s1 = dp[i - 1];
//            var s2 = strs[i];
//            int j = 0;
//            while (j < s1.length() && j < s2.length() && s1.charAt(j) == s2.charAt(j)) {
//                j++;
//            }
//            dp[i] = s1.substring(0, j);
//        }
//        return dp[n - 1];
//    }
}





