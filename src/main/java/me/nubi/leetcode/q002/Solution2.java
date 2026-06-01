package me.nubi.leetcode.q002;

import me.nubi.leetcode.type.ListNode;

class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        int inc = 0;
        ListNode cur=null;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + inc;
            if (cur == null) {
                cur = new ListNode();
                head = cur;
            } else {
                cur.next = new ListNode();
                cur= cur.next;
            }
            cur.val = sum % 10;
            inc = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1 == null ? l2 : l1;
        while (remain!=null) {
            int sum = remain.val + inc;
            cur.next = new ListNode();
            cur = cur.next;
            cur.val = sum % 10;
            inc = sum / 10;
            remain = remain.next;
        }
        if (inc > 0) {
            cur.next = new ListNode(inc);
        }
        return head;
    }
}