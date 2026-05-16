package me.nubi.leetcode.q283;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class Q283Test {

    @Test
    public void test() {
        int[] nums = new int[] {0,1,0,3,12};
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        System.out.println("result=" + JSON.toJSONString(nums));
        nums = new int[] {45192,0,-659,-52359,-99225,-75991,0,-15155,27382,59818,0,-30645,-17025,81209,887,64648};
        solution.moveZeroes(nums);
        System.out.println("result=" + JSON.toJSONString(nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[] {0,1,0,3,12};
        Solution2 solution = new Solution2();
        solution.moveZeroes(nums);
        System.out.println("result=" + JSON.toJSONString(nums));
        nums = new int[] {45192,0,-659,-52359,-99225,-75991,0,-15155,27382,59818,0,-30645,-17025,81209,887,64648};
        solution.moveZeroes(nums);
        System.out.println("result=" + JSON.toJSONString(nums));
        nums = new int[] {4,2,4,0,0,3,0,5,1,0};
        solution.moveZeroes(nums);
        System.out.println("result=" + JSON.toJSONString(nums));
    }
}
