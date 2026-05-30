package me.nubi.leetcode.q20;

import org.junit.Assert;
import org.junit.Test;

public class Q20S2Test {

    @Test
    public void test3() {
        Solution2 solution2 = new Solution2();
        Assert.assertFalse(solution2.isValid("({[)"));
    }

    @Test
    public void test4() {
        Solution2 solution = new Solution2();
        Assert.assertFalse(solution.isValid("(]"));
    }

    @Test
    public void test5() {
        Solution2 solution = new Solution2();
        Assert.assertTrue(solution.isValid("()"));
    }

    @Test
    public void test6() {
        Solution2 solution = new Solution2();
        Assert.assertTrue(solution.isValid("([])"));
    }

    @Test
    public void test7() {
        Solution2 solution2 = new Solution2();
        Assert.assertFalse(solution2.isValid("){"));
    }
}
