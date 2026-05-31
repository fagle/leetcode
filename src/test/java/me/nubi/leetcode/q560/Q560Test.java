package me.nubi.leetcode.q560;

import org.junit.Assert;
import org.junit.Test;

public class Q560Test {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.subarraySum(new int[]{1, 1, 1}, 2));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.subarraySum(new int[]{1, 2, 1, 2, 1}, 4));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.subarraySum(new int[]{-1,-1,1}, 1));
    }
}
