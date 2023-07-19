package com.wgx.hundred.day52;

import java.util.LinkedList;

/**
 * @author wgx
 * @since 2023/7/17 17:54
 */
public class Dota2参议院 {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RD"));
    }

    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        var radiant = new LinkedList<Integer>();
        var dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIdx = radiant.poll(), direIdx = dire.poll();
            if (radiantIdx < direIdx) {
                radiant.offer(radiantIdx + n);
            } else {
                dire.offer(direIdx + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
