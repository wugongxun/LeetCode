package com.wgx.fifty.day29;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/3/11 13:26
 *
 * 执行用时: 1393 ms
 */
public class 字母与数字 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findLongestSubarray(new String[]{
                "A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"
        })));
    }

    public static String[] findLongestSubarray(String[] array) {
        //使用HashMap优化
        int n = array.length;
        var prefix = new int[n + 1];
        //字母为1，数字为-1，字母的ASCII码为01xxxxxx，数字的ASCII码为0011xxxx
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + (array[i].charAt(0) >> 6 & 1) * 2 - 1;
        }

        int left = 0, right = 0;
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i <= n; i++) {
            if (!map.containsKey(prefix[i])) {
                map.put(prefix[i], i);
            } else if (i - map.get(prefix[i]) > right - left) {
                left = map.get(prefix[i]);
                right = i;
            }
            
        }
        var res = new String[right - left];
        System.arraycopy(array, left, res, 0, right - left);
        return res;



//        int n = array.length;
//        var letterCount = 0;
//        var prefix = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            if (Character.isLetter(array[i].charAt(0))) {
//                letterCount++;
//            }
//            prefix[i + 1] = letterCount;
//        }
//        if (letterCount * 2 == n) {
//            return array;
//        }
//        for (int i = n; i >= 0; --i) {
//            for (int j = 0; j + i <= n; ++j) {
//                if ((prefix[j + i] - prefix[j]) * 2 == i) {
//                    var res = new String[i];
//                    for (int k = j; k < j + i; k++) {
//                        res[k - j] = array[k];
//                    }
//                    return res;
//                }
//            }
//        }
//        return new String[0];
    }
}
