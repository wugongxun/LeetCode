package com.wgx.day27;

import java.util.*;

/**
 * @author wgx
 * @since 2023/3/7 9:52
 */
public class 花括号展开II {
    public static void main(String[] args) {
        System.out.println(braceExpansionII("{a,b}{c,{d,e}}"));
    }



    public static List<String> braceExpansionII(String expression) {
        var op = new ArrayDeque<Character>();
        var stk = new ArrayList<Set<String>>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ',') {
                //不断地弹出栈顶运算符，直到栈为空或者栈顶不为乘号
                while (!op.isEmpty() && op.peek() == '*') {
                    ope(op.pop(), stk);
                }
                op.push('+');
            } else if (ch == '{') {
                //判断是否需要在前面加乘号（以下两种情况需要加乘号）
                //      1. '{'前面直接为'}'
                //      2. '{'前面为字母
                if (i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))) {
                    op.push('*');
                }
                op.push('{');
            } else if (ch == '}') {
                //不断地弹出栈顶运算符，直到栈顶为'{'
                while (!op.isEmpty() && op.peek() != '{') {
                    ope(op.pop(), stk);
                }
                //弹出'{'
                op.pop();
            } else {
                //判断是否需要在前面加乘号（以下两种情况需要加乘号）
                //      1. 字母前面直接为'}'
                //      2. 字母前面直接为字母
                if (i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))) {
                    op.push('*');
                }
                stk.add(new TreeSet(){{
                    add(ch + "");
                }});
            }
        }

        while (!op.isEmpty()) {
            ope(op.pop(), stk);
        }

        return new ArrayList(stk.get(stk.size() - 1));
    }

    //弹出栈顶运算符，并进行计算
    public static void ope(char op, List<Set<String>> stk) {
        //取出stk顶部的两个元素（集合），l为第一个，r为第二个
        int l = stk.size() - 2, r = stk.size() - 1;
        if (op == '+') {
            //op为加号，将第二个集合中的所有元素加到第一个集合中
            stk.get(l).addAll(stk.get(r));
        } else {
            //op为乘号，将两个集合的每个元素组合
            Set<String> tmp = new TreeSet();
            for (String left : stk.get(l)) {
                for (String right : stk.get(r)) {
                    tmp.add(left + right);
                }
            }
            //组合完成后赋值给第一个元素
            stk.set(l, tmp);
        }
        //删除第二个元素
        stk.remove(r);
    }
}
