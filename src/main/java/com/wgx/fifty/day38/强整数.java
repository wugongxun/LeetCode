package com.wgx.fifty.day38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wgx
 * @since 2023/5/2 15:10
 */
public class 强整数 {
    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2, 1, 10));
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        var res = new HashSet<Integer>();
        for (int i = 0;; ++i) {
            if (Math.pow(x, i) > bound) {
                break;
            }
            for (int j = 0;; ++j) {
                int temp = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (temp > bound) {
                    break;
                }
                res.add(temp);
            }
        }
        return new ArrayList<>(res);
    }
}
