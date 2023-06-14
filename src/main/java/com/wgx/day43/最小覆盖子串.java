package com.wgx.day43;

/**
 * @author wgx
 * @since 2023/6/14 11:34
 */
public class 最小覆盖子串 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    //滑动窗口
    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }

        var count = new int['z' - 'A' + 1];
        for (var ch : t.toCharArray()) {
            ++count[ch - 'A'];
        }
        int start = -1;
        int resLen = m + 1;
        int left = 0, right = 0;
        var chars = s.toCharArray();
        while (right < m) {
            var ch = chars[right++];
            if (count[ch - 'A']-- > 0) {
                --n;
            }
            if (n == 0) {
                while (count[chars[left] - 'A']++ < 0) {
                    ++left;
                }
                if (resLen > right - left) {
                    start = left;
                    resLen = right - left;
                }
                left++;
                n++;
            }
        }
        return start == -1 ? "" : s.substring(start, start + resLen);
    }
}
