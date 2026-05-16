package me.nubi.leetcode.q002;

import org.junit.Assert;
import org.junit.Test;

public class Q002Test {

    public Solution.ListNode create(int[] d) {
        Solution.ListNode l = null;
        Solution.ListNode rs = null;
        for (int i=0; i<d.length; i++) {
            if (i == 0) {
                l = new Solution.ListNode(d[i]);
                rs = l;
            }
            else {
                l.next = new Solution.ListNode(i);
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
    public boolean verify(int[] expect, Solution.ListNode data) {
        for (int i=0; i< expect.length; i++) {
            if (data.val != expect[i])
                return false;
            data = data.next;
        }
        return true;
    }

    @Test
    public void test() {
        Solution.ListNode l1 = create(new int[] {2,4,3});
        Solution.ListNode l2 = create(new int[] {5,6,4});

        Solution solution = new Solution();
        Solution.ListNode result = solution.addTwoNumbers(l1, l2);
        Assert.assertTrue(verify(new int[] {7, 0, 8}, result));

        l1 = create(new int[] {5});
        l2 = create(new int[] {5});
        result = solution.addTwoNumbers(l1, l2);
        Assert.assertTrue(verify(new int[] {0, 1}, result));
    }
}
