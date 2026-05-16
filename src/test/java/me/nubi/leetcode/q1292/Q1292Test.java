package me.nubi.leetcode.q1292;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

public class Q1292Test {

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[][] m = JSON.parseObject("[[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]", int[][].class);
        Assert.assertEquals(2, solution.maxSideLength(m, 4));

    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.maxSideLength(JSON.parseObject("[[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]]", int[][].class), 4));
    }

    @Test
    public void test22() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.maxSideLength(JSON.parseObject("[[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]]", int[][].class), 40184));
    }


    @Test
    public void test49() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.maxSideLength(JSON.parseObject(" [[0]]", int[][].class), 0));
    }



}
