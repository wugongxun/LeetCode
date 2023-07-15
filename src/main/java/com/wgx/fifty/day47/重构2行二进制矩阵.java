package com.wgx.fifty.day47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wgx
 * @since 2023/6/29 10:19
 */
public class 重构2行二进制矩阵 {
    public static void main(String[] args) {
//        System.out.println(reconstructMatrix(2, 1, new int[]{1, 1, 1}));
//        System.out.println(reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}));
//        System.out.println(reconstructMatrix(4, 2, new int[]{1, 2, 1, 2, 0}));
        System.out.println(reconstructMatrix(9, 2, new int[]{0, 1, 2, 0, 0, 0, 0, 0, 2, 1, 2, 1, 2}));
    }

    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        var res = new ArrayList<List<Integer>>();
        int sum = Arrays.stream(colsum).sum();
        if (upper + lower != sum) {
            return res;
        }
        var first = new int[n];
        var second = new int[n];
        for (int i = 0; i < n; ++i) {
            if (colsum[i] == 2) {
                if (upper > 0) {
                    first[i] = 1;
                    upper--;
                    colsum[i]--;
                } else {
                    second[i] = 1;
                    lower--;
                    colsum[i]--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 0) {
                continue;
            }
            if (upper > 0 && first[i] == 0) {
                first[i] = 1;
                upper--;
            } else if (lower > 0 && second[i] == 0) {
                second[i] = 1;
                lower--;
            } else {
                return res;
            }
        }
        res.add(Arrays.stream(first).boxed().collect(Collectors.toList()));
        res.add(Arrays.stream(second).boxed().collect(Collectors.toList()));
        return res;
    }
}
