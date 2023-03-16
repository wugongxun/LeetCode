package com.wgx.day30;

import java.util.Stack;

/**
 * @author wgx
 * @since 2023/3/15 11:11
 */
public class 逆波兰表达式求值 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        var num = new Stack<Integer>();
        for (var s : tokens) {
            switch (s) {
                case "+" -> {
                    int i1 = num.pop();
                    int i2 = num.pop();
                    num.push(i2 + i1);
                }
                case "-" -> {
                    int i1 = num.pop();
                    int i2 = num.pop();
                    num.push(i2 - i1);
                }
                case "*" -> {
                    int i1 = num.pop();
                    int i2 = num.pop();
                    num.push(i2 * i1);
                }
                case "/" -> {
                    int i1 = num.pop();
                    int i2 = num.pop();
                    num.push(i2 / i1);
                }
                default -> num.push(Integer.parseInt(s));
            }
        }
        return num.pop();
    }
}
