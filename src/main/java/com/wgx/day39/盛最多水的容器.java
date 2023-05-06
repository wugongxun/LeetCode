package com.wgx.day39;

/**
 * @author wgx
 * @since 2023/5/6 11:39
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            res = Math.max(res, h * (right - left));
            while (left < right && height[left] <= h) {
                left++;
            }
            while (left < right && height[right] <= h) {
                right--;
            }
        }
        return res;
    }

//    public int maxArea(int[] height) {
//        int n = height.length;
//        int res = 0;
//        for (int i = 0; i < n - 1; ++i) {
//            if (height[i + 1] - height[i] > 2 * height[i]) {
//                continue;
//            }
//            int maxHeight = 0;
//            for (int j = n - 1; j > i; --j) {
//                if (height[j] <= maxHeight) {
//                    continue;
//                }
//                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
//                maxHeight = height[j];
//                if (maxHeight >= height[i]) {
//                    break;
//                }
//            }
//        }
//        return res;
//    }
}
