package me.nubi.leetcode.q234;

import me.nubi.leetcode.type.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        int mid = len / 2;
        int leftEnd = mid - 1;
        if (len % 2 == 1) {
            leftEnd = mid ;
        }
        int i = 0;
        ListNode cur = head;
        while (i < leftEnd) {
            i++;
            cur = cur.next;
        }
        ListNode right = cur;
        ListNode midNode = right;
        if (leftEnd < mid) {
            right = right.next;
            cur.next = null;
        } else {
            ListNode temp = right.next;
            right.next = null;
            right = new ListNode(midNode.val);
            right.next = temp;
        }

        right = reverse(right);
        cur = head;
        while (cur!=null && right!=null && cur.val == right.val) {
            cur = cur.next;
            right = right.next;
        }
        return cur == null && right == null;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr.next != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;
        return curr;
    }
}