package com.wgx.周赛.第355场周赛;

import java.util.*;

/**
 * @author wgx
 * @since 2023/7/23 11:01
 */
public class 长度递增组的最大数目 {
    public static void main(String[] args) {
        var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(5);
        System.out.println(maxIncreasingGroups(list));
    }

    public static int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        long prefix = 0;
        int res = 0;
        for (var num : usageLimits) {
            prefix += num;
            if (prefix >= res + 1) {
                res++;
                prefix -= res;
            }
        }
        return res;
    }

//    public static int maxIncreasingGroups(List<Integer> usageLimits) {
//        int n = usageLimits.size();
//        Collections.sort(usageLimits);
//        int left = 1, right = n;
//        while (left < right) {
//            int mid = (left + right + 1) / 2, count = 0;
//            for (int i = 0; i < n; ++i) {
//                count += Math.max(0, mid - i);
//                count -= Math.min(count, usageLimits.get(n - i - 1));
//            }
//            if (count == 0) {
//                left = mid;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return left;
//    }

//    public static int maxIncreasingGroups(List<Integer> usageLimits) {
//        int n = usageLimits.size();
//        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
//        for (int i = 0; i < n; i++) {
//            pq.offer(usageLimits.get(i));
//        }
//        int res = 0;
//        int size = 1;
//        while (pq.size() >= size) {
//            var list = new ArrayList<Integer>(size);
//            for (int i = 0; i < size; i++) {
//                list.add(pq.poll() - 1);
//            }
//            for (var poll : list) {
//                if (poll > 0) {
//                    pq.offer(poll);
//                }
//            }
//            res++;
//            size++;
//        }
//        return res;
//    }
}
