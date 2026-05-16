package me.nubi.leetcode.q085;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q085Test {

    @Test
    public void test1() {
        char[][] m = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Solution solution = new Solution();
        Assert.assertEquals(6, solution.maximalRectangle(m));
    }

    @Test
    public void test2() {
        char[][] m = {{'0', '0', '1'}, {'1', '1', '1'}};
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.maximalRectangle(m));
    }

    @Test
    public void test3() {
        char[][] m =
                {{'0', '0', '1', '0'}, {'0', '0', '1', '0'}, {'0', '0', '1', '0'}, {'0', '0', '1', '1'}, {'0', '1', '1', '1'}, {
                        '0', '1', '1', '1'}, {'1', '1', '1', '1'}};
        Solution solution = new Solution();
        Assert.assertEquals(9, solution.maximalRectangle(m));
    }

    @Test
    public void test63() {
        char[][] m = {{'1', '0', '1', '1', '0', '1'}, {'1', '1', '1', '1', '1', '1'}, {'0', '1', '1', '0', '1', '1'}, {'1', '1', '1', '0', '1', '0'}, {'0', '1', '1', '1', '1', '1'}, {'1', '1', '0', '1', '1', '1'}};
        Solution solution = new Solution();
        Assert.assertEquals(8, solution.maximalRectangle(m));
    }

    @Test
    public void test74() {
        char[][] m = {{'1','0','1','0','1','1','1','0'},{'1','1','0','1','1','0','0','0'},{'1','1','1','0','0','1','0','1'},{'1','0','1','1','1','1','1','0'},{'0','0','0','1','1','1','1','0'}};
        Solution solution = new Solution();
        Assert.assertEquals(8, solution.maximalRectangle(m));
    }
}