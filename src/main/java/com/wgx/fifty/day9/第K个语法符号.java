package com.wgx.fifty.day9;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/20 9:38
 * 我们构建了一个包含 n 行(索引从 1 开始)的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数n和序数 k，返回第 n 行中第 k个字符。（k从索引 1 开始）
 */
public class 第K个语法符号 {
    public static void main(String[] args) {
        System.out.println(kthGrammar(1, 1));
    }

    public static int kthGrammar(int n, int k) {
        if (n == 1)
            return 0;
        /**
         * 第n行的第k个数字是有n - 1行的第(k + 1) / 2个数字得出
         * kthGrammar(n - 1, (k + 1) / 2)求出上一行的第(k + 1) / 2个数字
         * 上一行的第(k + 1) / 2个数字有有两种情况
         *          如果为0则生成01
         *          如果为1则生成10
         * (k & 1)求出k是奇数还是偶数
         *          如果为奇数则应该取出kthGrammar(n - 1, (k + 1) / 2)的第一位数
         *          如果为偶数则应该取出kthGrammar(n - 1, (k + 1) / 2)的第二位数
         * (k & 1) ^ 1
         *          如果k为奇数结果为00
         *          如果k为偶数结果为01
         * 00不管是异或0还是1结果都是01或者10的第一位数
         * 01不管是异或0还是1结果都是01或者10的第二位数
         */
        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }

//    public static String kthGrammar(int n) {
//        if (n == 1) {
//            return "0";
//        }
//        String prev = kthGrammar(n - 1);
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < prev.length(); i++) {
//            if (prev.charAt(i) == '0') {
//                builder.append("01");
//            } else {
//                builder.append("10");
//            }
//        }
//        return builder.toString();
//    }
}
