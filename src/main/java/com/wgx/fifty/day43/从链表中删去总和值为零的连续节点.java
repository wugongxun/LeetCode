package com.wgx.fifty.day43;

/**
 * @author wgx
 * @since 2023/6/11 14:29
 */
public class 从链表中删去总和值为零的连续节点 {
    public static void main(String[] args) {
//        System.out.println(removeZeroSumSublists(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(-2)))))));
        System.out.println(removeZeroSumSublists(new ListNode(1, new ListNode(2, new ListNode(-3, new ListNode(3, new ListNode(1)))))));
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }
        int sum = 0;
        var p = head;
        while (p != null) {
            sum += p.val;
            if (sum == 0) {
                return removeZeroSumSublists(p.next);
            }
            p = p.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }

//    public static ListNode removeZeroSumSublists(ListNode head) {
//        var list = new ArrayList<Integer>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        int[] nums = list.stream().mapToInt(i -> i).toArray();
//        int n = nums.length;
//        var prefix = new int[n + 1];
//        for (int i = 0; i < n; ++i) {
//            prefix[i + 1] = prefix[i] + nums[i];
//        }
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j < i; ++j) {
//                if (prefix[i] == prefix[j] && nums[j] != 1001) {
//                    for (int k = j + 1; k <= i; k++) {
//                        nums[k - 1] = 1001;
//                    }
//                }
//            }
//        }
//        ListNode res = new ListNode();
//        var cur = res;
//        for (int i = 0; i < n; ++i) {
//            if (nums[i] == 1001) {
//                continue;
//            }
//            cur.next = new ListNode(nums[i]);
//            cur = cur.next;
//        }
//        return res.next;
//    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}