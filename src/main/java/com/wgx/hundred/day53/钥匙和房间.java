package com.wgx.hundred.day53;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgx
 * @since 2023/7/20 16:12
 */
public class 钥匙和房间 {
    @Test
    public void test() {
        var rooms = new ArrayList<List<Integer>>();
        rooms.add(new ArrayList<>(){{add(1);}});
        rooms.add(new ArrayList<>(){{add(2);}});
        rooms.add(new ArrayList<>(){{add(3);}});
        rooms.add(new ArrayList<>());
        System.out.println(canVisitAllRooms(rooms));
    }

    int n;
    List<List<Integer>> rooms;
    boolean[] seen;
    int res;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        this.rooms = rooms;
        seen = new boolean[n];
        res = 0;
        dfs(0);
        return res == n;
    }

    public void dfs(int i) {
        seen[i] = true;
        res++;
        for (var key : rooms.get(i)) {
            if (!seen[key])
                dfs(key);
        }
    }
}
