package me.nubi.leetcode.q001;

import org.junit.Test;

/**
 * Created by Fagle on 2017/2/22 0022.
 */
public class Q001Test {
    @Test
    public void test () {
        Solution solution = new Solution();
        int[] nums = new int[] {3,2,4};
        for (int a : solution.twoSum(nums, 6))
            System.out.print(a + " ");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {2, 7, 11, 15};
        for (int a : solution.twoSum(nums, 9))
            System.out.print(a + " ");
    }
}
