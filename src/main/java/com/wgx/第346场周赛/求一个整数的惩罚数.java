package com.wgx.第346场周赛;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/5/21 10:50
 */
public class 求一个整数的惩罚数 {
    @Test
    public void test() {
        System.out.println(punishmentNumber(467));
    }

    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dfs(i, String.valueOf(i * i), 0, 0, 0)) {
                res += i * i;
            }
        }
        return res;
    }

    public boolean dfs(int num, String square, int index, int cur, int sum) {
        if (index >= square.length()) {
            return sum + cur == num;
        }
        if (sum > num) {
            return false;
        }
        if (sum == num && index == square.length()) {
            return true;
        }
        //截断
        int i = square.charAt(index) - '0';
        if (dfs(num, square, index + 1, 0, sum + (cur * 10 + i))) {
            return true;
        }
        //不截断
        if (dfs(num, square, index + 1, cur * 10 + i, sum)) {
            return true;
        }
        return false;
    }

//    List<Integer>[] adj;
//
//    public int punishmentNumber(int n) {
//        adj = new List[n * n + 1];
//        for (int i = 1; i <= n * n; i++) {
//            dfs(i);
//        }
//        int res = 0;
//        for (int i = 1; i <= n; i++) {
//            if (adj[i * i].contains(i)) {
//                res += i * i;
//            }
//        }
//        return res;
//    }
//
//    public void dfs(int num) {
//        var list = new ArrayList<Integer>();
//        String s = String.valueOf(num);
//        if (s.length() == 1) {
//            list.add(num);
//            adj[num] = list;
//            return;
//        }
//
//        for (int i = s.length() - 1; i > 0; --i) {
//            Integer tail = Integer.valueOf(s.substring(i));
//            for (Integer t : adj[Integer.valueOf(s.substring(0, i))]) {
//                list.add(t + tail);
//            }
//        }
//        list.add(num);
//        adj[num] = list;
//    }
}
