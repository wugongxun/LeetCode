package com.wgx.fifty.day16;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wgx
 * @since 2023/1/13 10:29
 */
public class 重排字符形成目标字符串 {
    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("ilovecodingonleetcode", "code"));
    }

    public static int rearrangeCharacters(String s, String target) {
//        Map<Character, Integer> map = new HashMap<>();
//        int res = 0;
//        while (true) {
//            for (int i = 0; i < target.length(); i++) {
//                char ch = target.charAt(i);
//                int formIndex = -1;
//                if (map.containsKey(ch)) {
//                    formIndex = map.get(ch);
//                }
//                int index = s.indexOf(ch, formIndex + 1);
//                if (index < 0) {
//                    return res;
//                } else {
//                    map.put(ch, index);
//                }
//            }
//            res++;
//        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            int total = sMap.containsKey(key) ? sMap.get(key) : 0;
            res = Math.min(res, total / val);
        }
        return res;
    }
}
