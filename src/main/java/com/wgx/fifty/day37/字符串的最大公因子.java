package com.wgx.fifty.day37;

/**
 * @author wgx
 * @since 2023/4/28 11:34
 */
public class 字符串的最大公因子 {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

//    public static String gcdOfStrings(String str1, String str2) {
//        int len1 = str1.length(), len2 = str2.length();
//
//        for (int i = Math.min(len1, len2); i > 0; --i) {
//            if (len1 % i == 0 && len2 % i == 0) {
//                String t = str1.substring(0, i);
//                if (check(t, str1) && check(t, str2)) {
//                    return t;
//                }
//            }
//        }
//        return "";
//    }
//
//    private static boolean check(String t, String s) {
//        int lenx = s.length() / t.length();
//        var sb = new StringBuilder();
//        for (int i = 0; i < lenx; i++) {
//            sb.append(t);
//        }
//        return s.equals(sb.toString());
//    }


//    public static String gcdOfStrings(String str1, String str2) {
//        var list1 = gcd(str1);
//        var list2 = gcd(str2);
//
//        String res = "";
//        for (var s1 : list1) {
//            for (var s2 : list2) {
//                if (s1.equals(s2) && s1.length() > res.length()) {
//                    res = s1;
//                }
//            }
//        }
//        return res;
//    }
//
//    public static List<String> gcd(String s) {
//        int n = s.length();
//        var res = new ArrayList<String>();
//        for (int i = 1; i <= n / 2; ++i) {
//            if (n % i == 0) {
//                var t = s.substring(0, i);
//                boolean flag = true;
//                for (int j = i; j + i <= n; j += i) {
//                    if (!t.equals(s.substring(j, j + i))) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    res.add(t);
//                }
//            }
//        }
//        res.add(s);
//        return res;
//    }
}
