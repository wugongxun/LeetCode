package com.wgx.fifty.day46;

/**
 * @author wgx
 * @since 2023/6/25 9:52
 */
public class 圆和矩形是否有重叠 {
    public static void main(String[] args) {
//        System.out.println(checkOverlap(1, 0, 0, 1, -1, 3, 1));
//        System.out.println(checkOverlap(1, 0, 0, -1, 0, 0, 1));
        System.out.println(checkOverlap(10, 10, 1, 0, 0, 100, 100));
    }

    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        double dis = 0;
        if (xCenter < x1 || xCenter > x2) {
            dis += Math.min(Math.pow(x1 - xCenter, 2), Math.pow(x2 - xCenter, 2));
        }
        if (yCenter < y1 || yCenter > y2) {
            dis += Math.min(Math.pow(y1 - yCenter, 2), Math.pow(y2 - yCenter, 2));
        }
        return dis <= radius * radius;
    }
}
