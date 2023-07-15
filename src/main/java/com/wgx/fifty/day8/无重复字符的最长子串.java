package com.wgx.fifty.day8;

import java.util.HashMap;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/17 10:49
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
//        int ans = 0;
//        Queue<Character> queue = new LinkedList<>();
//        for (char c : s.toCharArray()) {
//            while (queue.contains(c)) {
//                queue.poll();
//            }
//            queue.add(c);
//            ans = Math.max(ans, queue.size());
//        }
//        return ans;


        int left = 0, right = 0, ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                int index = map.get(ch);
                for (int i = left; i <= index; i++) {
                    map.remove(s.charAt(i));
                }
                left = index + 1;
            }
            map.put(ch, right);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
