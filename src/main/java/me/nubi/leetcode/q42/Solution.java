package me.nubi.leetcode.q42;

public class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxHeightL = height[left];
        int maxHeightR = height[right];
        int sum = 0;
        while(right > left) {
            if (height[left] < height[right]) {
                if (height[left] < maxHeightL) {
                    sum += maxHeightL - height[left];
                } else {
                    maxHeightL = height[left];
                }
                left++;
            } else {
                if (height[right] < maxHeightR) {
                    sum += maxHeightR - height[right];
                } else {
                    maxHeightR = height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
