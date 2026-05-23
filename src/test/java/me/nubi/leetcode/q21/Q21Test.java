package me.nubi.leetcode.q21;

import me.nubi.leetcode.type.ListNode;
import org.junit.Test;

public class Q21Test {
    @Test
    public void test() {
        int [] arr1 = new int[] {1,2,4};
        int [] arr2 = new int[] {1,3,4};
        Solution s = new Solution();
        printList(s.mergeTwoLists(buildList(arr1), buildList(arr2)));
    }

    private ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    private void printList(ListNode head) {
        if (head == null) return;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
