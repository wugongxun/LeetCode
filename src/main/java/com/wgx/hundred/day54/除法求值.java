package com.wgx.hundred.day54;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wgx
 * @since 2023/7/21 16:42
 */
public class 除法求值 {
    @Test
    public void test() {
        var equations = new ArrayList<List<String>>();
        equations.add(new ArrayList<>(){{add("a");add("b");}});
        equations.add(new ArrayList<>(){{add("b");add("c");}});
        var queries = new ArrayList<List<String>>();
        queries.add(new ArrayList<>(){{add("a");add("c");}});
        queries.add(new ArrayList<>(){{add("b");add("a");}});
        System.out.println(Arrays.toString(calcEquation(equations, new double[]{2, 3}, queries)));
    }

    Map<String, List<String[]>> map;
    Set<String> set;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int  n = values.length;
        map = new HashMap<>();
        set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            var equ = equations.get(i);
            var dividend = equ.get(0);
            var divisor = equ.get(1);
            set.add(dividend);
            set.add(divisor);
            if (map.containsKey(dividend)) {
                map.get(dividend).add(new String[]{divisor, String.valueOf(values[i])});
            } else {
                var list = new ArrayList<String[]>();
                list.add(new String[]{divisor, String.valueOf(values[i])});
                map.put(dividend, list);
            }
            if (map.containsKey(divisor)) {
                map.get(divisor).add(new String[]{dividend, String.valueOf(1 / values[i])});
            } else {
                var list = new ArrayList<String[]>();
                list.add(new String[]{dividend, String.valueOf(1 / values[i])});
                map.put(divisor, list);
            }
        }
        int m = queries.size();
        var res = new double[m];
        var used = new ArrayList<String>();
        for (int i = 0; i < m; ++i) {
            var query = queries.get(i);
            used.add(query.get(0));
            var dfs = dfs(query.get(0), query.get(1), 1D, used);
            if (dfs == -1) {
                dfs = 1 / dfs(query.get(1), query.get(0), 1D, used);
            }
            used.clear();
            res[i] = dfs;
        }
        return res;
    }

    public double dfs(String dividend, String divisor, double res, List<String> used) {
        if (dividend.equals(divisor)) {
            return set.contains(dividend) ? res : -1;
        }
        if (map.containsKey(dividend)) {
            var list = map.get(dividend);
            for (var s : list) {
                if (!used.contains(s[0])) {
                    used.add(s[0]);
                    var dfs = dfs(s[0], divisor, res * Double.parseDouble(s[1]), used);
                    if (dfs != -1) {
                        return dfs;
                    }
                    used.remove(used.size() - 1);
                }
            }
        }
        return -1;
    }

}
