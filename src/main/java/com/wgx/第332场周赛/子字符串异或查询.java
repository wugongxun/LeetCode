package com.wgx.第332场周赛;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wgx
 * @since 2023/2/12 11:30
 */
public class 子字符串异或查询 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(substringXorQueries("101101", new int[][]{{0, 5}, {1, 2}})));
    }

//    public static int[][] substringXorQueries(String s, int[][] queries) {
//        int[][] res = new int[queries.length][2];
//        for (int i = 0; i < queries.length; i++) {
//            String s1 = Integer.toBinaryString(queries[i][0] ^ queries[i][1]);
//            int index  = s.indexOf(s1);
//            if (index != -1) {
//                res[i] = new int[]{index, index + s1.length() - 1};
//            } else {
//                res[i] = new int[]{-1, -1};
//            }
//        }
//        return res;
//    }

    public static int[][] substringXorQueries(String s, int[][] queries) {
        var map = new HashMap<Integer, int[]>();
        for (int i = 30; i > 0; i--) {
            for (int j = s.length() - i; j >= 0; j--) {
                map.put(Integer.parseInt(s.substring(j, j + i), 2), new int[]{j , j + i - 1});
            }
        }
        var res = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            res[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], new int[]{-1, -1});
        }
        return res;
    }
}
