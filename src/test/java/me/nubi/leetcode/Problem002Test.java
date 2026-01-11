package me.nubi.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Problem002Test {

    public Problem002.ListNode create(int[] d) {
        Problem002.ListNode l = null;
        Problem002.ListNode rs = null;
        for (int i=0; i<d.length; i++) {
            if (i == 0) {
                l = new Problem002.ListNode(d[i]);
                rs = l;
            }
            else {
                l.next = new Problem002.ListNode(i);
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
    public boolean verify(int[] expect, Problem002.ListNode data) {
        for (int i=0; i< expect.length; i++) {
            if (data.val != expect[i])
                return false;
            data = data.next;
        }
        return true;
    }

    @Test
    public void test() {
        Problem002.ListNode l1 = create(new int[] {2,4,3});
        Problem002.ListNode l2 = create(new int[] {5,6,4});

        Problem002.Solution solution = new Problem002.Solution();
        Problem002.ListNode result = solution.addTwoNumbers(l1, l2);
        Assert.assertTrue(verify(new int[] {7, 0, 8}, result));

        l1 = create(new int[] {5});
        l2 = create(new int[] {5});
        result = solution.addTwoNumbers(l1, l2);
        Assert.assertTrue(verify(new int[] {0, 1}, result));
    }
}
