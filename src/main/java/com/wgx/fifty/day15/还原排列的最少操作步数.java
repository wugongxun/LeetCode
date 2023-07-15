package com.wgx.fifty.day15;

/**
 * @author wgx
 * @since 2023/1/9 9:28
 */
public class 还原排列的最少操作步数 {
    public static void main(String[] args) {
        System.out.println(reinitializePermutation(4));
    }

//    public static int reinitializePermutation(int n) {
//        int[] original = new int[n];
//        int[] prev = new int[n];
//        for (int i = 0; i < n; i++) {
//            original[i] = i;
//            prev[i] = i;
//        }
//        int[] arr = new int[n];
//        int res = 0;
//        while (!Arrays.equals(arr, original)) {
//            for (int i = 0; i < n; i++) {
//                if (i % 2 == 0) {
//                    arr[i] = prev[i / 2];
//                } else {
//                    arr[i] = prev[n / 2 + (i - 1) / 2];
//                }
//            }
//            prev = Arrays.copyOf(arr, n);
//            res++;
//        }
//        return res;
//    }

    public static int reinitializePermutation(int n) {
        int res = 0;
        int i = 1;
        do {
            if (i % 2 == 0){
                i /= 2;
            } else if (i % 2 == 1) {
                i = n / 2 + (i - 1) / 2;
            }
            res++;
        } while (i != 1);
        return res;
    }

}
