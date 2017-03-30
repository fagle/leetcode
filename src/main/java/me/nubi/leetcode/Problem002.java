package me.nubi.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fagle on 2017/3/30.
 * 2. Add Two Numbers
 */
public class Problem002 {

    public class ListNode {
        int val;
        ListNode next;
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
    public class Solution {
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

    public ListNode create(int[] d) {
        ListNode l = null;
        ListNode rs = null;
        for (int i=0; i<d.length; i++) {
            if (i == 0) {
                l = new ListNode(d[i]);
                rs = l;
            }
            else {
                l.next = new ListNode(i);
                l = l.next;
                l.val = d[i];
            }
        }
        return rs;
    }
    /***
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */
    public boolean verify(int[] expect, ListNode data) {
        for (int i=0; i< expect.length; i++) {
            if (data.val != expect[i])
                return false;
            data = data.next;
        }
        return true;
    }

    @Test
    public void test() {
        ListNode l1 = create(new int[] {2,4,3});
        ListNode l2 = create(new int[] {5,6,4});

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        Assert.assertTrue(verify(new int[] {7, 0, 8}, result));

        l1 = create(new int[] {5});
        l2 = create(new int[] {5});
        result = solution.addTwoNumbers(l1, l2);
        Assert.assertTrue(verify(new int[] {0, 1}, result));
    }
}
