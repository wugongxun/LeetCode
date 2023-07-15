package com.wgx.周赛.第344场周赛;

/**
 * @author wgx
 * @since 2023/5/7 10:51
 */
public class 频率跟踪器 {
    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(5);
        frequencyTracker.add(5);
        System.out.println(frequencyTracker.hasFrequency(1));
        System.out.println(frequencyTracker.hasFrequency(2));
    }
}
class FrequencyTracker {
    int[] count;
    int[] frequencies;

    public FrequencyTracker() {
        count = new int[100001];
        frequencies = new int[100001];
    }

    public void add(int number) {
        if (count[number] > 0) {
            frequencies[count[number]]--;
        }
        frequencies[++count[number]]++;
    }

    public void deleteOne(int number) {
        if (count[number] > 0) {
            frequencies[count[number]]--;
            frequencies[--count[number]]++;
        }
    }

    public boolean hasFrequency(int frequency) {
        return frequencies[frequency] > 0;
    }
}