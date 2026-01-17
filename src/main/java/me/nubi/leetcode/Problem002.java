package me.nubi.leetcode;

/**
 * Created by fagle on 2017/3/30.
 * 2. Add Two Numbers
 */
public class Problem002 {

    public static class ListNode {
        int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum;
            int add =0;
            ListNode result=null;
            ListNode node=null;

            while (l1 != null || l2 != null) {
                if (l1 == null ) {
                    sum = l2.val;
                    l2 = l2.next;
                }
                else if (l2 == null) {
                    sum = l1.val;
                    l1 = l1.next;
                }
                else {
                    sum = l1.val + l2.val;
                    l1 = l1.next;
                    l2 = l2.next;
                }

                sum += add;
                if (result == null) {
                    result = new ListNode(0);
                    node = result;
                } else {
                    node.next = new ListNode(0);
                    node = node.next;
                }
                if (sum >= 10) {
                    add = 1;
                    node.val = sum - 10;
                }
                else {
                    add = 0;
                    node.val = sum;
                }
            }
            if (add > 0)
                node.next = new ListNode(1);

            return result;
        }
    }
}
