package me.nubi.leetcode.q011;

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (right>left) {
            int s = (right - left) * Math.min(height[left], height[right]);
            if (s > max) {
                max = s;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}