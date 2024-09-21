package com.wgx.hundred.day68;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wgx
 * @since 2024/7/15 22:04
 */
public class 账户合并 {

    @Test
    public void test() {
        var list = new ArrayList<List<String>>();
        list.add(new ArrayList<>(List.of("David", "David0@m.co", "David1@m.co")));
        list.add(new ArrayList<>(List.of("David", "David3@m.co", "David4@m.co")));
        list.add(new ArrayList<>(List.of("David", "David4@m.co", "David5@m.co")));
        list.add(new ArrayList<>(List.of("David", "David2@m.co", "David3@m.co")));
        list.add(new ArrayList<>(List.of("David", "David1@m.co", "David2@m.co")));
        System.out.println(accountsMerge(list));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        var emailToIdx = new HashMap<String, List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                emailToIdx.computeIfAbsent(accounts.get(i).get(j), x -> new ArrayList<>()).add(i);
            }
        }

        var res = new ArrayList<List<String>>();
        var vis = new boolean[n];
        var emailSet = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            emailSet.clear();
            dfs(i, accounts, emailToIdx, vis, emailSet);
            var list = new ArrayList<>(emailSet);
            Collections.sort(list);
            list.add(0, accounts.get(i).get(0));
            res.add(list);
        }

        return res;
    }

    public void dfs(int i, List<List<String>> accounts, Map<String, List<Integer>> emailToIdx, boolean[] vis, Set<String> emailSet) {
        vis[i] = true;
        for (int j = 1; j < accounts.get(i).size(); j++) {
            var email = accounts.get(i).get(j);
            if (emailSet.contains(email)) {
                continue;
            }
            emailSet.add(email);
            for (var next : emailToIdx.get(email)) {
                if (!vis[next]) {
                    dfs(next, accounts, emailToIdx, vis, emailSet);
                }
            }
        }
    }

}
