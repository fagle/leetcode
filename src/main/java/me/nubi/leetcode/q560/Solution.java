package me.nubi.leetcode.q560;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int sum = 0;
        prefixSumCount.put(0, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += prefixSumCount.getOrDefault(sum-k, 0);
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}