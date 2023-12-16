package com.wgx.hundred.day64;

import org.junit.jupiter.api.Test;

/**
 * @author wgx
 * @since 2023/12/9 11:18
 */
public class 下一个更大的数值平衡数 {
    @Test
    public void test() {
        System.out.println(nextBeautifulNumber(1224443));
    }

    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            var x = i;
            var count = new int[10];
            boolean isBeautiful = true;
            for (; x > 0; x /= 10) {
                var idx = x % 10;
                if (++count[idx] > idx || idx == 0) {
                    isBeautiful = false;
                    break;
                }
            }
            if (isBeautiful) {
                for (int j = 0; j < 10; j++) {
                    if (count[j] != 0 && count[j] != j) {
                        isBeautiful = false;
                        break;
                    }
                }
            }
            if (isBeautiful)
                return i;
        }
        return 0;
    }
}
