package me.nubi.leetcode.q001;

/**
 * Created by Fagle on 2017/2/22 0022.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {

        for (int i=0; i<nums.length; i++) {
            int j = search(nums, i+1, target - nums[i]);
            if ( j > -1) {
                return new int[] {i, j};
            }
        }
        return null;
    }

    private int search(int [] nums, int src, int target) {
        for (int i= src; i<nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}