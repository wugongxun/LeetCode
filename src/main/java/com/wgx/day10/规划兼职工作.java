package com.wgx.day10;

import java.util.*;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/22 14:20
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 * <p>
 * 这里有n份兼职工作，每份工作预计从startTime[i]开始到endTime[i]结束，报酬为profit[i]。
 * <p>
 * 给你一份兼职工作表，包含开始时间startTime，结束时间endTime和预计报酬profit三个数组，请你计算并返回可以获得的最大报酬。
 * <p>
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 * <p>
 * 如果你选择的工作在时间X结束，那么你可以立刻进行在时间X开始的下一份工作。
 */
public class 规划兼职工作 {
    public static void main(String[] args) {
        System.out.println(jobScheduling(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60}));
    }

    public static Stack<int[]> binarySearch(int[][] arr, int key) {
        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid][2] == key) {
                Stack<int[]> res = new Stack<>();
                res.push(arr[mid]);
                int i = mid + 1, j = mid - 1;
                while (i <= right && arr[i][2] == key) {
                    res.push(arr[i]);
                    i++;
                }
                while (j >= left && arr[j][2] == key) {
                    res.push(arr[j]);
                    j--;
                }
                return res;
            } else if (arr[mid][2] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }


//    [1,2,3,3]
//    [3,4,5,1000000000]
//    [50,10,40,70]
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int length = profit.length;
        //merge[i][0]表示第份工作，merge[i][1]表示这份工作的起始时间，merge[i][2]表示这份工作的结束时间，merge[i][3]表示这份工作的利润
        int[][] merge = new int[length][4];
        for (int i = 0; i < length; i++) {
            merge[i][0] = i;
            merge[i][1] = startTime[i];
            merge[i][2] = endTime[i];
            merge[i][3] = profit[i];
        }
        Arrays.sort(merge, Comparator.comparingInt(o -> o[2]));
        int[] dp = new int[length];
        dp[0] = merge[0][3];
        for (int i = 1; i < length; i++) {
            int start = merge[i][1];
            int prev = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (merge[j][2] <= start) {
                    prev = j;
                    break;
                }
            }
            if (prev != -1) {
                dp[i] = Math.max(merge[i][3] + dp[prev], dp[i - 1]);
            } else {
                dp[i] = Math.max(merge[i][3], dp[i - 1]);
            }
        }
        return dp[length - 1];


//        int maxEnd = 0;
//        //merge[i][0]表示第份工作，merge[i][1]表示这份工作的起始时间，merge[i][2]表示这份工作的结束时间，merge[i][3]表示这份工作的利润
//        int[][] merge = new int[profit.length][4];
//        for (int i = 0; i < endTime.length; i++) {
//            maxEnd = Math.max(maxEnd, endTime[i]);
//            merge[i][0] = i;
//            merge[i][1] = startTime[i];
//            merge[i][2] = endTime[i];
//            merge[i][3] = profit[i];
//        }
//        //dp[i]表示以第i天为结束的最大利润
//        int[] dp = new int[maxEnd + 1];
//        Arrays.sort(merge, Comparator.comparingInt(o -> o[2]));
//        for (int i = 2; i < dp.length; i++) {
//            Stack<int[]> res = binarySearch(merge, i);
//            if (res != null) {
//                int start;
//                int maxProfit = 0;
//                while (!res.isEmpty()) {
//                    int[] arr = res.pop();
//                    start = arr[1];
//                    maxProfit = Math.max(maxProfit, dp[start] + arr[3]);
//                }
//                dp[i] = Math.max(maxProfit, dp[i - 1]);
//            } else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[maxEnd];


//        int length = profit.length;
//        //dailyProfit[i][0] 表示第几份工作 dailyProfit[i][1]表示这分工作的每日利润
//        double[][] dailyProfit = new double[length][2];
//        for (int i = 0; i < length; i++) {
//            dailyProfit[i][0] = i;
//            dailyProfit[i][1] = (double) profit[i] / (endTime[i] - startTime[i]);
//        }
//        Arrays.sort(dailyProfit, Comparator.comparingDouble(o -> o[1]));
//        int maxProfit = 0;
//        for (int i = length - 1; i >= 0; i--) {
//            //从最大的每日利润的工作开始遍历
//            int day = (int) dailyProfit[i][0];
//            int j = length - 1;
//            int thisProfit = profit[day];
//            int start = startTime[day];
//            int end = endTime[day];
//            //遍历寻找是否还有能做到工作
//            while (j >= 0) {
//                int nextDay = (int) dailyProfit[j][0];
//                if (startTime[nextDay] >= end) {
//                    end = endTime[nextDay];
//                    thisProfit += profit[nextDay];
//                }
//                if (endTime[nextDay] <= start) {
//                    start =startTime[nextDay];
//                    thisProfit += profit[nextDay];
//                }
//                j--;
//            }
//            maxProfit = Math.max(thisProfit, maxProfit);
//        }
//        return maxProfit;
    }
}
