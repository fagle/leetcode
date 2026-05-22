package me.nubi.leetcode.q160;
import me.nubi.leetcode.type.ListNode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        int diff = lenA - lenB;
        curA = headA;
        curB = headB;
        while (diff != 0) {
            if (diff > 0) {
                curA = curA.next;
                diff--;
            } else {
                curB = curB.next;
                diff++;
            }
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
