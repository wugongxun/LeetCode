package com.wgx.hundred.day60;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wgx
 * @since 2023/8/7 16:35
 */
public class 删除无效的括号 {
    @Test
    public void test() {
//        System.out.println(removeInvalidParentheses("(a)())()"));
        System.out.println(removeInvalidParentheses("()"));
    }

    public List<String> removeInvalidParentheses(String s) {
        if (isValid(s))
            return List.of(s);
        return new ArrayList<>(bfs(Set.of(s)));
    }

    public Set<String> bfs(Set<String> set) {
        var res = new HashSet<String>();
        var next = new HashSet<String>();
        for (var s : set) {
            int n = s.length();
            for (int i = 0; i < n; i++) {
                var ch = s.charAt(i);
                if (ch == '(' || ch == ')') {
                    var t = s.substring(0, i) + s.substring(i + 1);
                    next.add(t);
                    if (isValid(t)) {
                        res.add(t);
                    }
                }
            }
        }
        if (next.isEmpty()) {
            return set;
        }
        if (res.isEmpty()) {
            res.addAll(bfs(next));
        }
        return res;
    }

    public boolean isValid(String s) {
        var count = 0;
        for (var ch : s.toCharArray()) {
            if (ch == '(')
                count++;
            else if (ch == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}
