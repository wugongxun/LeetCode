package com.wgx.fifty.day32;

/**
 * @author wgx
 * @since 2023/3/28 10:07
 */
public class 最短公共超序列 {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
    }


    static String s, t;
    static int[][] cache;

    public static String shortestCommonSupersequence(String str1, String str2) {
        s = str1;
        t = str2;
        cache = new int[s.length()][t.length()];
        return makeAns(s.length() - 1, t.length() - 1);
    }

    public static int dfs(int i, int j) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        if (cache[i][j] > 0) {
            return cache[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            return cache[i][j] = dfs(i - 1, j - 1) + 1;
        }

        return cache[i][j] = Math.min(dfs(i - 1, j), dfs(i, j - 1)) + 1;
    }

    public static String makeAns(int i, int j) {
        //边界条件
        if (i < 0) {
            return t.substring(0, j + 1);
        }
        if (j < 0) {
            return s.substring(0, i + 1);
        }
        //如果s和t的最后一个字符相同，直接都截取掉最后一个字符递归，再加上最后一个字符
        if (s.charAt(i) == t.charAt(j)) {
            return makeAns(i - 1, j - 1) + s.charAt(i);
        }
        //如果s和t的最后一个字符不同，使用dfs判断截取s的长度和截取t的长度
        if (dfs(i, j - 1) > dfs(i - 1, j)) {
            return makeAns(i - 1, j) + s.charAt(i);
        } else {
            return makeAns(i, j - 1) + t.charAt(j);
        }
    }



//    public static String shortestCommonSupersequence(String str1, String str2) {
//        //如果str1或者str2为空，直接返回另一个
//        if (str1.isEmpty()) {
//            return str2;
//        }
//        if (str2.isEmpty()) {
//            return str1;
//        }
//
//        var sub1 = str1.substring(0, str1.length() - 1);
//        var sub2 = str2.substring(0, str2.length() - 1);
//        var c1 = str1.charAt(str1.length() - 1);
//        var c2 = str2.charAt(str2.length() - 1);
//        //如果str1或者str2的最后一个字符相同，将str1和str2都截取递归，再加上最后一个字符
//        if (c1 == c2) {
//            return shortestCommonSupersequence(sub1, sub2) + c1;
//        }
//        var res1 = shortestCommonSupersequence(str1, sub2);
//        var res2 = shortestCommonSupersequence(sub1, str2);
//        //如果str1或者str2的最后一个字符不同，比较递归得到的长度，将较短的加上截取掉的字符为答案
//        if (res1.length() < res2.length()) {
//            return res1 + c2;
//        } else {
//            return res2 + c1;
//        }
//    }

//    String s1, s2;
//
//    public String shortestCommonSupersequence(String str1, String str2) {
//        s1 = str1;
//        s2 = str2;
//        return dfs(0, 0, new StringBuilder()).toString();
//    }
//
//    public StringBuilder dfs(int i, int j, StringBuilder sb) {
//        if (i == s1.length() && j == s2.length()) {
//            return sb;
//        }
//
//        //选s1
//        var sb1 = new StringBuilder();
//        if (i < s1.length()) {
//            int _j = j;
//            if (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
//                _j++;
//            }
//            sb1 = dfs(i + 1, _j, sb1.append(sb).append(s1.charAt(i)));
//        }
//
//        //选s2
//        var sb2 = new StringBuilder();
//        if (j < s2.length()) {
//            int _i = i;
//            if (i < s1.length() && s1.charAt(i) == s2.charAt(j)) {
//                _i++;
//            }
//            sb2 = dfs(_i, j + 1, sb2.append(sb).append(s2.charAt(j)));
//        }
//
//        if (sb1.isEmpty()) {
//            return sb2;
//        } else if (sb2.isEmpty()) {
//            return sb1;
//        } else {
//            return sb1.length() > sb2.length() ? sb2 : sb1;
//        }
//    }
}
