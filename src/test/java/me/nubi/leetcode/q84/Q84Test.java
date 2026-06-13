package me.nubi.leetcode.q84;

import me.nubi.leetcode.q084.Solution2;
import org.junit.Assert;
import org.junit.Test;

public class Q84Test {

    @Test
    public void test1() {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        Solution2 solution2 = new Solution2();
        System.out.println("result=" + solution2.largestRectangleArea(heights));
    }

    @Test
    public void test2() {
        int[] heights = new int[]{2, 1, 2};
        Solution2 solution2 = new Solution2();
        int result = solution2.largestRectangleArea(heights);
        Assert.assertEquals(3, result);
        System.out.println("result=" + result);
    }
}
