package com.wgx.day14;

/**
 * @author wgx
 * @since 2023/1/5 9:35
 */
public class 统计异或值在范围内的数对有多少 {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1,4,2,7}, 2, 6));
    }

    //根节点
    private static Trie root;
    //二进制的最大深度
    private static final int HIGH_BIT = 14;

    public static int countPairs(int[] nums, int low, int high) {
        root = new Trie();
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            res += get(nums[i], high) - get(nums[i], low - 1);
        }
        return res;
    }

    public static void add(int num) {
        //将num的二进制表示放入到字典树中
        Trie cur = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (cur.son[bit] == null)
                cur.son[bit] = new Trie();
            cur = cur.son[bit];
            cur.sum++;
        }
    }

    public static int get(int num, int x) {
        //求出字典树与num各位异或的结果是否小于x
        Trie cur = root;
        int sum = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            //num的第i位
            int bit = (num >> i) & 1;
            if (((x >> i) & 1) == 1) {
                //如果x的第i位为1，则字典树只有和num的第i位相同异或结果才能小于x
                if (cur.son[bit] != null) {
                    //cur.son[bit]不为null表示出现过，累加
                    sum += cur.son[bit].sum;
                }
                //bit ^ 1，表示与bit相反的二进制位
                //如果bit相反的二进制位没有出现过，此时num与字典树中的值的异或都小于x，直接返回
                if (cur.son[bit ^ 1] == null) {
                    return sum;
                }
                //否则进入下一层继续判断
                cur = cur.son[bit ^ 1];
            } else {
                //如果x的第i位为0，只有字典树和num的第i位相同才有可能在下一层出现小于x的异或可能
                if (cur.son[bit] == null) {
                    return sum;
                }
                //存在字典树和num的第i位相同，进入下一层判断
                cur = cur.son[bit];
            }
        }
        //如果字典树中的数值与num的异或，存在等于k的情况，就会来到字典树的末尾
        sum += cur.sum;
        return sum;
    }

}

class Trie {
    // son[0]表示0，son[1]表示1
    Trie[] son;
    //sum表示这个前缀出现了几次
    int sum;

    public Trie() {
        son = new Trie[2];
        sum = 0;
    }
}
