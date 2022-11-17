package com.wgx.day7;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/13 10:39
 */
public class 有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < c.length; i++) {
            Character ch = map.get(c[i]);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(c[i]);
            }
        }
        return stack.isEmpty();
    }
}
