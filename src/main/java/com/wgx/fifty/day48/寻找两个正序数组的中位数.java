package com.wgx.fifty.day48;

/**
 * @author wgx
 * @since 2023/7/9 20:58
 */
public class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {

    }

    int n, m;
    int[] nums1, nums2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        int len = n + m;
        if (len % 2 == 1) {
            return getKthELement(len / 2 + 1);
        } else {
            return (getKthELement(len / 2) + getKthELement(len / 2 + 1)) / 2D;
        }
    }

    public double getKthELement(int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        //nums1和nums2的指针
        int idx1 = 0, idx2 = 0;
        while (true) {
            //idx1已经到nums1的最后，直接返回nums2的第idx2 + k + 1位
            if (idx1 == n) {
                return nums2[idx2 + k - 1];
            }
            //idx2已经到nums2的最后，直接返回nums1的第idx1 + k + 1位
            if (idx2 == m) {
                return nums1[idx1 + k - 1];
            }
            //k为1，返回min(nums1[idx1], nums2[idx2])
            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }
            int half = k / 2;
            //k / 2 - 1，可能下标越界，需要判断
            int newIdx1 = Math.min(idx1 + half, n) - 1;
            int newIdx2 = Math.min(idx2 + half, m) - 1;
            int pivot1 = nums1[newIdx1], pivot2 = nums2[newIdx2];
            //设置新下标，以及k减去删除的数的个数
            if (pivot1 <= pivot2) {
                k -= newIdx1 - idx1 + 1;
                idx1 = newIdx1 + 1;
            } else {
                k -= newIdx2 - idx2 + 1;
                idx2 = newIdx2 + 1;
            }
        }
    }

    //枚举
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//        int idx1 = 0, idx2 = 0;
//        int pre = -1, cur = -1;
//        for (int i = 0; i <= (n + m) / 2; ++i) {
//            pre = cur;
//            if (idx1 < n && (idx2 >= m || nums1[idx1] < nums2[idx2])) {
//                cur = nums1[idx1++];
//            } else {
//                cur = nums2[idx2++];
//            }
//        }
//        if ((n + m & 1) == 0) {
//            return (pre + cur) / 2D;
//        } else {
//            return cur;
//        }
//    }
}
