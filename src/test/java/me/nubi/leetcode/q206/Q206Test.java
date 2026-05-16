package me.nubi.leetcode.q206;

import org.junit.Test;

public class Q206Test {
    @Test
    public void test() {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5 };
        Solution.ListNode head = new Solution.ListNode(arr[0]);
        Solution.ListNode cur = head;
        for (int i=1; i<arr.length; i++) {
            cur.next = new Solution.ListNode(arr[i]);
            cur = cur.next;
        }
        cur = sol.reverseList(head);
        printLinkList(cur);
    }

    private void printLinkList(Solution.ListNode head) {
        Solution.ListNode cur = head;
        while (cur != null) {
            System.out.println("node=" + cur.val);
            cur = cur.next;
        }
    }
}
