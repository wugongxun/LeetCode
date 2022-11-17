package com.wgx.day8;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/17 9:52
 */
public class 水果成篮 {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    public static int totalFruit(int[] fruits) {
        int len = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        for (; right < len; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                Integer leftVal = map.get(fruits[left]);
                map.put(fruits[left], --leftVal);
                if (leftVal == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;

//        int[] max = new int[fruits.length];
//        for (int i = 0; i < fruits.length; i++) {
//            if (i - 1 >= 0 && fruits[i] == fruits[i - 1])
//                continue;
//            int basket1 = fruits[i];
//            int basket2 = -1;
//            int count = 1;
//            for (int j = i + 1; j < fruits.length; j++) {
//                if (fruits[j] == basket1 || fruits[j] == basket2) {
//                    count++;
//                } else if (basket2 == -1) {
//                    count++;
//                    basket2 = fruits[j];
//                } else {
//                    break;
//                }
//            }
//            max[i] = count;
//        }
//        Arrays.sort(max);
//        return max[max.length - 1];
    }
}
