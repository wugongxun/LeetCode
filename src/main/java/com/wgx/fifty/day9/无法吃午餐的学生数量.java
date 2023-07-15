package com.wgx.fifty.day9;

import java.util.Arrays;

/**
 * @author wgx
 * @version 1.0
 * @since 2022/10/19 9:42
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字 0 和 1 表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个 栈 里，每一轮：
 *
 * 如果队列最前面的学生 喜欢 栈顶的三明治，那么会 拿走它 并离开队列。
 * 否则，这名学生会 放弃这个三明治 并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 *
 * 给你两个整数数组 students 和 sandwiches ，其中 sandwiches[i] 是栈里面第 i​​​​​​ 个三明治的类型（i = 0 是栈的顶部）， students[j] 是初始队列里第 j​​​​​​ 名学生对三明治的喜好（j = 0 是队列的最开始位置）。请你返回无法吃午餐的学生数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 无法吃午餐的学生数量 {
    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();//s1表示喜欢方形的学生数量
        int s0 = students.length - s1;//s0表示喜欢圆形的学生数量

        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && s0 > 0)
                s0--;
            else if (sandwiches[i] == 1 && s1 > 0)
                s1--;
            else
                break;
        }
        return s1 + s0;


        //使用队列
//        List<Integer> list = Arrays.stream(students).boxed().collect(Collectors.toList());
//        Queue<Integer> queue = new LinkedList<>(list);
//        for (int i = 0; i < sandwiches.length; i++) {
//            int size = queue.size();
//            for (int j = 0; j < size; j++) {
//                Integer poll = queue.poll();
//                if (poll != sandwiches[i]) {
//                    queue.add(poll);
//                } else {
//                    break;
//                }
//            }
//            if (size == queue.size()) {
//                return queue.size();
//            }
//        }
//        return 0;

//        int rest = 0;
//        int move = 0;
//        label:
//        for (int i = 0; i < sandwiches.length; i++) {
//            int sandwich = sandwiches[i];
//            move = rest;
//            while (true) {
//                if (students[move] != -1 && students[move] == sandwich) {
//                    students[move] = -1;
//                    rest = (move + 1) % students.length;
//                    break;
//                }
//                if ((move + 1) % students.length == rest) {
//                    break label;
//                }
//                move = (move + 1) % students.length;
//            }
//        }
//        int count = 0;
//        for (int i = 0; i < students.length; i++) {
//            if (students[i] != -1)
//                count++;
//        }
//        return count;
    }
}
