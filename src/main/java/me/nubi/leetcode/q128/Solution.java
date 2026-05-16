package me.nubi.leetcode.q128;

import java.util.TreeSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        int cnt = 1;
        int max = 1;
        int last = 0;
        boolean first = true;
        for (int cur : treeSet) {
            if (first) {
                last = cur;
                first = false;
                continue;
            }
            if (cur - last == 1) {
                cnt ++;
                if (cnt>max) {
                    max = cnt;
                }
            } else {
                cnt = 1;
            }
            last = cur;
        }
        return max;
    }
}