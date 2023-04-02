package com.wgx.day32;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wgx
 * @since 2023/3/30 10:07
 */
public class 两点之间不包含任何点的最宽垂直区域 {
    public static void main(String[] args) {

    }

    public int maxWidthOfVerticalArea(int[][] points) {
        return Arrays.stream(points).sorted(Comparator.comparingInt(i -> i[0])).reduce(new int[]{Integer.MAX_VALUE, 0}, (res, item) -> new int[]{item[0], Math.max(res[1], item[0] - res[0])})[1];
    }
}
