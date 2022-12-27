package com.wgx.day12;

import java.util.Comparator;
import java.util.HashMap;

/**
 * @author wgx
 * @since 2022/11/23 10:12
 */
public class 盒子中小球的最大数量 {
    public static void main(String[] args) {
        countBalls(1, 10);
    }

    public static int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> boxs = new HashMap<>();
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int x = i;
            int box = 0;
            while (x != 0) {
                box += x % 10;
                x /= 10;
            }
            boxs.put(box, boxs.getOrDefault(box, 0) + 1);
            res = Math.max(res, boxs.get(box));
        }
        return res;
    }
}
