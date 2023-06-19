package com.wgx.第350场周赛;

/**
 * @author wgx
 * @since 2023/6/18 10:37
 */
public class 总行驶距离 {
    public static void main(String[] args) {
        System.out.println(distanceTraveled(9, 2));
    }

    public static int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while (mainTank >= 5) {
            if (additionalTank > 0) {
                mainTank -= 4;
                additionalTank--;
            } else {
                mainTank -= 5;
            }
            res += 50;
        }

        return res + mainTank * 10;
    }
}
