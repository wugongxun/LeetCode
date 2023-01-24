package com.wgx.day17;

import java.util.Arrays;

/**
 * @author wgx
 * @since 2023/1/16 9:44
 */
public class 句子相似性III {
    public static void main(String[] args) {
        System.out.println(areSentencesSimilar("A B C D B B", "A B B"));
    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = 0, j = 0;
        while (i < len1 && i < len2 && arr1[i].equals(arr2[i])) {
            i++;
        }
        if (i == Math.min(len1, len2))
            return true;
        while (j < len1 - i && j < len2 - i && arr1[len1 - j - 1].equals(arr2[len2 -j - 1])) {
            j++;
        }
        return i + j == Math.min(len1, len2);
    }
}
