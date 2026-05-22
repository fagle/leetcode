package me.nubi.leetcode.q234;

import me.nubi.leetcode.type.ListNode;
import org.junit.Test;

public class Q234Test {
    @Test
    public void test1() {
        int [] arr = new int[] { 1,2,2,1 };
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        Solution sol = new Solution();
        System.out.println("result=" + sol.isPalindrome(head));
    }
}
