package me.nubi.leetcode.q15;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int lastNum = nums[0];
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length-2; first++) {
            if (first == 0 || nums[first] != lastNum) {
                int second = first + 1;
                int third = nums.length -1;
                int lastSecondNum = nums[second];
                while (second < third) {
                    int sum = sum(nums[first], nums[second], nums[third]);
                    if (sum == 0 && (second == first+1 || nums[second] > lastSecondNum)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        result.add(list);
                        lastSecondNum = nums[second];
                        second++;
                        third--;
                    } else if (sum > 0) {
                        third--;
                    } else {
                        second++;
                    }
                }
            }
            lastNum = nums[first];
        }
        return result;
    }

    private int sum(int first, int second, int third) {
        return first + second + third;
    }
}
