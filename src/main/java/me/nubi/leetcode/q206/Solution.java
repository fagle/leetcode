package me.nubi.leetcode.q206;


import me.nubi.leetcode.type.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        cur.next = pre;
        return cur;
    }


}