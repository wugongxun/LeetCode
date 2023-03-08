package com.wgx.day27;

/**
 * @author wgx
 * @since 2023/3/5 13:57
 */
public class 经营摩天轮的最大利润 {
    public static void main(String[] args) {
        System.out.println(minOperationsMaxProfit(new int[]{8, 3}, 5, 6));
    }

    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int waits = 0, profit = 0, maxProfit = 0, times = 0, n = customers.length, bestTimes = 0;
        while (waits != 0 || times < n) {
            if (times < n) {
                waits += customers[times];
            }
            int t = waits >= 4 ? 4 : waits;
            waits -= t;
            profit += boardingCost * t - runningCost;
            times++;
            if (profit > maxProfit) {
                maxProfit = profit;
                bestTimes = times;
            }
        }
        return bestTimes == 0 ? -1 : bestTimes;
    }
}
