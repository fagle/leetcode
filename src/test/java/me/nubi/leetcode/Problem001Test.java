package me.nubi.leetcode;

import org.junit.Test;

/**
 * Created by Fagle on 2017/2/22 0022.
 */
public class Problem001Test {
    @Test
    public void test () {
        Problem001 solution = new Problem001();
        int[] nums = new int[] {3,2,4};
        for (int a : solution.twoSum(nums, 6))
            System.out.print(a + " ");
    }

    public static void main(String[] args) {
        Problem001 solution = new Problem001();
        int[] nums = new int[] {2, 7, 11, 15};
        for (int a : solution.twoSum(nums, 9))
            System.out.print(a + " ");
    }
}
