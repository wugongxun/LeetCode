package com.wgx.day33;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author wgx
 * @since 2023/4/11 11:26
 */
public class 水壶问题 {
    public static void main(String[] args) {
        System.out.println(canMeasureWater(2, 6, 5));
    }


    public static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        var set = new HashSet<Long>();
        var deque = new LinkedList<int[]>();
        deque.push(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] arr = deque.pop();
            if (set.contains(hash(arr))) {
                continue;
            }

            set.add(hash(arr));
            int remainX = arr[0], remainY = arr[1];
            if (remainX == targetCapacity || remainY == targetCapacity || remainX + remainY == targetCapacity) {
                return true;
            }
            //把 X 壶的水灌进 Y 壶，直至灌满或倒空；
            if (remainX != 0)
                deque.push(new int[]{remainX - Math.min(remainX, jug2Capacity - remainY), remainY + Math.min(remainX, jug2Capacity - remainY)});
            //把 Y 壶的水灌进 X 壶，直至灌满或倒空；
            if (remainY != 0)
                deque.push(new int[]{remainX + Math.min(remainY, jug1Capacity - remainX), remainY - Math.min(remainY, jug1Capacity - remainX)});
            //把 X 壶灌满；
            deque.push(new int[]{jug1Capacity, remainY});
            //把 Y 壶灌满；
            deque.push(new int[]{remainX, jug2Capacity});
            //把 X 壶倒空；
            if (remainX != 0)
                deque.push(new int[]{0, remainY});
            //把 Y 壶倒空。
            if (remainY != 0)
                deque.push(new int[]{remainX, 0});
        }
        return false;
    }

    public static long hash(int[] arr) {
        return (long) arr[0] * 1000001 + arr[1];
    }
}
