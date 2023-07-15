package com.wgx.fifty.day26;

/**
 * @author wgx
 * @since 2023/3/2 10:06
 */
public class 二进制数转字符串 {
    public static void main(String[] args) {
        System.out.println(printBin(0.1));
    }

    public static String printBin(double num) {
        var res = new StringBuilder("0.");
        while (num != 0 && res.length() <= 32) {
            int i = (int) (num * 2);
            num = num * 2 - i;
            res.append(i);
        }
        return res.length() <= 32 ? res.toString() : "ERROR";
    }
}
