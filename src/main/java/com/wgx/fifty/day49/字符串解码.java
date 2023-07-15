package com.wgx.fifty.day49;

import java.util.LinkedList;

/**
 * @author wgx
 * @since 2023/7/11 21:57
 */
public class 字符串解码 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        int n = s.length();
        var num = new LinkedList<String>();
        var letter = new LinkedList<String>();
        for (int i = 0; i < n; ++i) {
            var ch = s.substring(i, i + 1);
            if (Character.isLetter(ch.charAt(0))) {
                letter.push(ch);
            } else if (Character.isDigit(ch.charAt(0))) {
                num.push(ch);
            } else if (ch.equals("[")) {
                letter.push(ch);
                num.push(ch);
            } else {
                String t = "";
                while (!letter.isEmpty() && !letter.peek().equals("[")) {
                    t += letter.pop();
                }
                letter.pop();
                String k = "";
                num.pop();
                while (!num.isEmpty() && !num.peek().equals("[")) {
                    k = num.pop() + k;
                }
                letter.push(t.repeat(Integer.parseInt(k)));
            }
        }
        var sb = new StringBuilder();
        while (!letter.isEmpty()) {
            sb.append(letter.pop());
        }
        return sb.reverse().toString();
    }

//    public static String decodeString(String s) {
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
