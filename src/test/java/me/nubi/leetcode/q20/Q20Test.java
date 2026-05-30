package me.nubi.leetcode.q20;

import org.junit.Assert;
import org.junit.Test;

public class Q20Test {

    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isValid("(]"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isValid("()"));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isValid("([])"));
    }
}
