package me.nubi.leetcode.q15;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class Q15Test {
    @Test
    public void test() {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        Solution s = new Solution();
        System.out.println(JSON.toJSONString(s.threeSum(nums)));

    }

    @Test
    public void test2() {
        Solution s = new Solution();
        int[] nums = new int[] { -100,-70,-60,110,120,130,160 };
        System.out.println(JSON.toJSONString(s.threeSum(nums)));
    }

    @Test
    public void test3() {
        Solution s = new Solution();
        int[] nums = new int[] { 1,2,0,1,0,0,0,0 };
        System.out.println(JSON.toJSONString(s.threeSum(nums)));
    }

}
