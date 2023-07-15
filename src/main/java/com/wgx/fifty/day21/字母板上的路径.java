package com.wgx.fifty.day21;

/**
 * @author wgx
 * @since 2023/2/12 13:59
 */
public class 字母板上的路径 {
    public static void main(String[] args) {
        System.out.println(alphabetBoardPath("zz"));
    }

    public static String alphabetBoardPath(String target) {
        var curPos = new int[]{0, 0};
        var res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            int ch = target.charAt(i) - 'a';
            int divider = ch / 5;
            int mod = ch % 5;
            if (curPos[0] == divider && curPos[1] == mod) {
                res.append('!');
                continue;
            }
            if (curPos[0] == 5 && curPos[1] == 0) {
                curPos[0] = 4;
                res.append('U');
            }
            int xDiff = Math.abs(curPos[1] - mod);
            boolean xSgn = curPos[1] >= mod;
            for (int j = 0; j < xDiff; j++) {
                res.append(xSgn ? 'L' : 'R');
            }
            int yDiff = Math.abs(curPos[0] - divider);
            boolean ySgn = curPos[0] >= divider;
            for (int j = 0; j < yDiff; j++) {
                res.append(ySgn ? 'U' : 'D');
            }
            curPos[0] = divider;
            curPos[1] = mod;
            res.append('!');
        }
        return res.toString();
    }
}
