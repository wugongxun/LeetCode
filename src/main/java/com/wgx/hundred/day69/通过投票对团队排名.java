package com.wgx.hundred.day69;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author wgx
 * @since 2024/12/29 15:48
 */
public class 通过投票对团队排名 {

    @Test
    public void test() {
        System.out.println(rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
//        System.out.println(rankTeams(new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"}));
    }

    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        var cnts = new int[26][n];
        for (var vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                cnts[vote.charAt(i) - 'A'][i]++;
            }
        }
        return votes[0]
                .chars()
                .mapToObj(c -> (char) c)
                .sorted((a, b) -> {
                    int[] cntA = cnts[a - 'A'], cntB = cnts[b - 'A'];
                    int compare = Arrays.compare(cntA, cntB);
                    return compare == 0 ? a - b : -compare;
                })
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
