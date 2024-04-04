package com.wgx.hundred.day66;

/**
 * @author wgx
 * @since 2024/3/31 14:58
 */
public class 验证二叉树的前序序列化 {

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

//    public static boolean isValidSerialization(String preorder) {
//        int n = preorder.length();
//        var stack = new LinkedList<Integer>();
//        stack.push(1);
//        int i = 0;
//        while (i < n) {
//            if (stack.isEmpty())
//                return false;
//            var ch = preorder.charAt(i);
//            if (ch == ',')
//                i++;
//            else if (ch == '#') {
//                var top = stack.pop() - 1;
//                if (top > 0)
//                    stack.push(top);
//                i++;
//            } else {
//                while (i < n && preorder.charAt(i) != ',')
//                    i++;
//                var top = stack.pop() - 1;
//                if (top > 0)
//                    stack.push(top);
//                stack.push(2);
//            }
//        }
//        return stack.isEmpty();
//    }

    public static boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int slots = 1;
        int i = 0;
        while (i < n) {
            if (slots == 0)
                return false;
            var ch = preorder.charAt(i);
            if (ch == ',')
                i++;
            else if (ch == '#') {
                slots--;
                i++;
            } else {
                while (i < n && preorder.charAt(i) != ',')
                    i++;
                slots++;
            }
        }
        return slots == 0;
    }

}
