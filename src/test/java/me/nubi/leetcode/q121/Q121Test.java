package me.nubi.leetcode.q121;

import org.junit.Assert;
import org.junit.Test;

public class Q121Test {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] arr = new int[]{2, 4, 1};
        Assert.assertEquals(2, solution.maxProfit(arr));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] arr = new int[]{ 3,2,6,5,0,3 };
        Assert.assertEquals(4, solution.maxProfit(arr));
    }
}
