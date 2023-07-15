package com.wgx.fifty.day22;

import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/2/13 10:02
 */
public class 替换子串得到平衡字符串 {
    public static void main(String[] args) {
        System.out.println(balancedString("QQQW"));
    }

    public static int balancedString(String s) {
        var dic = new HashMap<Character, Integer>(4);
        dic.put('Q', 0);
        dic.put('W', 1);
        dic.put('E', 2);
        dic.put('R', 3);
        var charArr = s.toCharArray();
        var countArr = new int[4];
        for (int i = 0; i < charArr.length; i++) {
            countArr[dic.get(charArr[i])]++;
        }

        int res = charArr.length;
        int div = charArr.length / 4;

        for (int i = 0, j = 0; i < charArr.length; i++) {
            while (j < charArr.length && !check(countArr, div)) {
                countArr[dic.get(charArr[j])]--;
                j++;
            }
            if (!check(countArr, div)) {
                break;
            }
            res = Math.min(res, j - i);
            countArr[dic.get(charArr[i])]++;
        }
        return res;
    }

    public static boolean check(int[] countArr, int div) {
        for (int i = 0; i < 4; i++) {
            if (countArr[i] > div) {
                return false;
            }
        }
        return true;
    }
}
