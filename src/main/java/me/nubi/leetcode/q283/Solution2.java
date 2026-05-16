package me.nubi.leetcode.q283;

public class Solution2 {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = 1;
        while (left < nums.length && right < nums.length) {
            if (nums[left] == 0) {
                if (nums[right] !=0) {
                    nums[left] = nums[right];
                    nums[right] = 0;
                    left ++;
                }
            } else {
                left++;
            }
            right++;
        }
    }
}
