package com.wgx.hundred.day51;

/**
 * @author wgx
 * @since 2023/7/15 13:44
 */
public class 最长有效括号 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }


    //dp
    public static int longestValidParentheses(String s) {
        int n = s.length();
        var dp = new int[n];
        var chars = s.toCharArray();
        int res = 0;
        for (int i = 1; i < n; ++i) {
            var ch = chars[i];
            if (ch == ')' && i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

//    public static int longestValidParentheses(String s) {
//        int n = s.length();
//        if (n <= 1) {
//            return 0;
//        }
//        var chars = s.toCharArray();
//        var stack = new LinkedList<Integer>();
//        var nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            var ch = chars[i];
//            if (ch == ')' && !stack.isEmpty() && chars[stack.peek()] == '(') {
//                Integer pop = stack.pop();
//                nums[pop] = 1;
//                nums[i] = 1;
//            } else {
//                stack.push(i);
//            }
//        }
//        int res = 0;
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == 1) {
//                count++;
//            } else {
//                res = Math.max(res, count);
//                count = 0;
//            }
//        }
//        return Math.max(res, count);
//    }
}
