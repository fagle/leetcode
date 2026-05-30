package me.nubi.leetcode.q169;

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (count == 0) {
                candidate = num;
                count++;
            } else {
                count += candidate == num ? 1 : -1;
            }
        }
        return candidate;
    }
}