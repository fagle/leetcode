package me.nubi.leetcode.q35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int pos = (left + right) / 2;
            if (nums[pos] == target) {
                return pos;
            }
            if (nums[pos] > target) {
                right = pos;
            } else {
                left = pos;
            }
        }
        if (nums[left] >= target) {
            return left;
        }
        if (target <= nums[right]) {
            return right;
        }
        return right + 1;
    }
}