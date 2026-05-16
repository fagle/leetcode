package me.nubi.leetcode.q011;

import org.junit.Test;

public class Q011Test {
    @Test
    public void test() {
        Solution s = new Solution();
        int[] nums = new int[] { 1,8,6,2,5,4,8,3,7 };
        int max = s.maxArea(nums);
        System.out.println("result=" + max);
    }
}
