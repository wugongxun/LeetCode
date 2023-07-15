package com.wgx.fifty.day7;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/13 10:07
 */
public class 最多能完成排序的块 {
    public static void main(String[] args) {
//        System.out.println(maxChunksToSorted(new int[]{0, 4, 5, 2, 1, 3, 6}));
    }

//    public static int maxChunksToSorted(int[] arr) {
//        int count = 0;
//        int maxVal = arr[0];
//        int minVal = arr[0];
//        Stack<Integer> stack = new Stack();
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] >= maxVal) {
//                count++;
//                maxVal = arr[i];
//                stack.push(minVal);
//                if (i < arr.length - 1)
//                    minVal = arr[i + 1];
//            } else {
//                while (!stack.isEmpty() && stack.peek() > minVal) {
//                    stack.pop();
//                }
//                count = stack.size() + 1;
//            }
//        }
//        return count;
//    }
}
