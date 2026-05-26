package me.nubi.leetcode.q35;

import org.junit.Test;

public class Q35Test {

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println("result=" + solution.searchInsert(new int[] { 1,3 }, 4));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        System.out.println("result=" + solution.searchInsert(new int[] { 1,3,5,6 }, 2));
    }
}
