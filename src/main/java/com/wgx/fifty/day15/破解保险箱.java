package com.wgx.fifty.day15;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wgx
 * @since 2023/1/10 11:09
 */
public class 破解保险箱 {
    public static void main(String[] args) {
        System.out.println(crackSafe(2, 2));
    }

    public static String crackSafe(int n, int k) {
        StringBuilder ans = new StringBuilder();
        Deque<String> deque = new ArrayDeque();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            ans.append("0");
        }
        deque.add(ans.toString());
        set.add(ans.toString());
        while (!deque.isEmpty()) {
            String pw = deque.poll();
            for (int i = 1; i >= 0; i--) {
                String npw = pw.substring(1) + i;
                if (set.contains(npw)) {
                    continue;
                }
                deque.addLast(npw);
                set.add(npw);
                ans.append(i);
                break;
            }
        }
        return ans.toString();
    }
}
