package me.nubi.leetcode;

/**
 * Created by Fagle on 2017/2/22 0022.
 */
public class Problem001 {
    public int[] twoSum(int[] nums, int target) {

        for (int i=0; i<nums.length; i++) {
            int j = search(nums, i, target - nums[i]);
            if ( j > -1) {
                return new int[] {i, j};
            }
        }
        return null;
    }

    private int search(int [] nums, int src, int target) {
        for (int i=0; i<nums.length; i++) {
            if (i == src)
                continue;
            if (target == nums[i])
                return i;
        }
        return -1;
    }
}