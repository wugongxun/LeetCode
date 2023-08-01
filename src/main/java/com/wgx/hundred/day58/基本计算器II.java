package com.wgx.hundred.day58;

import java.util.ArrayDeque;

/**
 * @author wgx
 * @since 2023/8/1 16:02
 */
public class 基本计算器II {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
//        System.out.println(calculate(" 3+5 / 2 "));
//        System.out.println(calculate("1-1+1"));
    }

    public static int calculate(String s) {
        var stack = new ArrayDeque<Integer>();
        var preSign = '+';
        int n = s.length();
        int num = 0;
        for (int i = 0; i < n; ++i) {
            var ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                preSign = ch;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
