package me.nubi.leetcode.q128;

import org.junit.Test;


public class Q128Test {

    @Test
    public void test() {
        int[] nums = new int[] { 100,4,200,1,3,2 };
        Solution solution = new Solution();
        int result = solution.longestConsecutive(nums);
        System.out.println("result=" + result);
    }


}
