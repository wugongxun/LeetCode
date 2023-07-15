package com.wgx.fifty.day42;

/**
 * @author wgx
 * @since 2023/6/8 15:36
 */
public class 铺瓷砖 {
    public static void main(String[] args) {

    }

    int n, m;
    //填充情况
    //filled[i] = j，表示第i行的填充情况为j的二进制表示
    //例如filled[0] = 3（二进制为11），表示第一行前两个被填充，后面没有被填充
    int[] filled;
    int res;

    public int tilingRectangle(int n, int m) {
        this.n = n;
        this.m = m;
        res = n * m;
        filled = new int[n];
        dfs(0, 0, 0);
        return res;
    }

    //i表示当前行数，j表示当前行的第几块，t表示当前瓷砖数
    public void dfs(int i, int j, int t) {
        //如果j == m说明已经到达最后一块，继续下一行
        if (j == m) {
            ++i;
            j = 0;
        }
        //如果j == m并且i == n说明，已经遍历完了，直接返回
        if (i == n) {
            res = t;
            return;
        }
        //filled[i]向右位移j位，即当前这一块是否被填充
        //如果当前行已经被填充，直接继续下一块
        if ((filled[i] >> j & 1) == 1) {
            dfs(i, j + 1, t);
            //t + 1如果大于等于res就没有要继续了，继续下去也不是最小的瓷砖数
        } else if (t + 1 < res) {
            //遍历下一块瓷砖的大小情况
            //row为最大的行，col为最大的列
            int row = 0, col = 0;
            for (int k = i; k < n; ++k) {
                if ((filled[k] >> j & 1) == 1) {
                    break;
                }
                ++row;
            }
            for (int k = j; k < m; ++k) {
                if ((filled[i] >> k & 1) == 1) {
                    break;
                }
                ++col;
            }
            //因为瓷砖必须为正方形，所以取row和col的最小值
            int maxWidth = Math.min(row, col);
            //w为下一块瓷砖的宽度，遍历可能的情况
            for (int w = 1; w <= maxWidth; ++w) {
                for (int k = 0; k < w; ++k) {
                    //将filled充填
                    filled[i + w - 1] |= 1 << (j + k);
                    filled[i + k] |= 1 << (j + w - 1);
                }
                dfs(i, j + w, t + 1);
            }
            //恢复现场
            for (int x = i; x < i + maxWidth; ++x) {
                for (int y = j; y < j + maxWidth; ++y) {
                    filled[x] ^= 1 << y;
                }
            }
        }
    }
}
