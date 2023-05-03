package com.wgx.day38;

/**
 * @author wgx
 * @since 2023/5/3 14:53
 */
public class 检查替换后的词是否有效 {
    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 3 != 0) {
            return false;
        }
        var sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            var ch = s.charAt(i);
            sb.append(ch);
            if (sb.length() >= 3 && sb.substring(sb.length() - 3).equals("abc")) {
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        return sb.isEmpty();
    }

//    public static boolean isValid(String s) {
//        int n = s.length();
//        if (n % 3 != 0) {
//            return false;
//        }
//        while (!s.isBlank()) {
//            int index = s.indexOf("abc");
//            if (index == -1) {
//                return false;
//            }
//            s = s.substring(0, index) + s.substring(index + 3);
//        }
//        return true;
//    }
}
