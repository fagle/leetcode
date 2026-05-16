package me.nubi.leetcode.q283;

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i=nums.length -1; i>=0; i--) {
            if (nums[i] == 0) {
                for (int j=i; j<nums.length-1; j++) {
                    if (nums[j+1] != 0) {
                        nums[j] = nums[j+1];
                        nums[j+1] = 0;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
