package me.nubi.leetcode.q70;

import java.util.HashMap;

class Solution {

    private HashMap<Integer, Integer> n2Result = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (n2Result.containsKey(n)) {
            return n2Result.get(n);
        }
        int result = climbStairs(n-1) + climbStairs(n-2);
        n2Result.put(n, result);
        return result;
    }
}