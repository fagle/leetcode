package me.nubi.leetcode.q206;

import me.nubi.leetcode.type.ListNode;
import org.junit.Test;

public class Q206Test {
    @Test
    public void test() {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5 };
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i=1; i<arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        cur = sol.reverseList(head);
        printLinkList(cur);
    }

    private void printLinkList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println("node=" + cur.val);
            cur = cur.next;
        }
    }
}
