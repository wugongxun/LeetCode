package com.wgx.fifty.day49;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @author wgx
 * @since 2023/7/11 21:57
 */
public class 字符串解码 {
    @Test
    public void test() {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    int p;
    String s;

    public String decodeString(String s) {
        var stack = new LinkedList<String>();
        p = 0;
        this.s = s;

        while (p < s.length()) {
            var ch = s.charAt(p);
            if (Character.isDigit(ch)) {
                stack.push(getDigits());
            } else if (Character.isLetter(ch) || ch == '[') {
                stack.push(String.valueOf(ch));
                p++;
            } else {
                ++p;
                StringBuilder t = new StringBuilder();
                while (!"[".equals(stack.peek())) {
                    t.insert(0, stack.pop());
                }
                stack.pop();
                int k = Integer.parseInt(stack.pop());
                stack.push(t.toString().repeat(k));
            }
        }
        var res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollLast());
        }
        return res.toString();
    }

    public String getDigits() {
        var sb = new StringBuilder();
        while (Character.isDigit(s.charAt(p))) {
            sb.append(s.charAt(p++));
        }
        return sb.toString();
    }

//    public String decodeString(String s) {
//        int n = s.length();
//        var num = new LinkedList<String>();
//        var letter = new LinkedList<String>();
//        for (int i = 0; i < n; ++i) {
//            var ch = s.substring(i, i + 1);
//            if (Character.isLetter(ch.charAt(0))) {
//                letter.push(ch);
//            } else if (Character.isDigit(ch.charAt(0))) {
//                num.push(ch);
//            } else if (ch.equals("[")) {
//                letter.push(ch);
//                num.push(ch);
//            } else {
//                String t = "";
//                while (!letter.isEmpty() && !letter.peek().equals("[")) {
//                    t += letter.pop();
//                }
//                letter.pop();
//                String k = "";
//                num.pop();
//                while (!num.isEmpty() && !num.peek().equals("[")) {
//                    k = num.pop() + k;
//                }
//                letter.push(t.repeat(Integer.parseInt(k)));
//            }
//        }
//        var sb = new StringBuilder();
//        while (!letter.isEmpty()) {
//            sb.append(letter.pop());
//        }
//        return sb.reverse().toString();
//    }

//    public String decodeString(String s) {
//        int n = s.length();
//        var queue = new ArrayDeque<String>();
//        for (int i = 0; i < n; ++i) {
//            var ch = s.substring(i, i + 1);
//            if (ch.equals("]")) {
//                var t = "";
//                while (!queue.peek().equals("[")) {
//                    t += queue.pop();
//                }
//                queue.pop();
//                String k = "";
//                while (!queue.isEmpty() && Character.isDigit(queue.peek().charAt(0))) {
//                    k = queue.pop() + k;
//                }
//                queue.push(t.repeat(Integer.valueOf(k)));
//            } else {
//                queue.push(ch);
//            }
//        }
//        var sb = new StringBuilder();
//        while (!queue.isEmpty()) {
//            sb.append(queue.pop());
//        }
//        return sb.reverse().toString();
//    }
}
