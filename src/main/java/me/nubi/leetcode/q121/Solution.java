package me.nubi.leetcode.q121;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 计算今日相对最低点的利润，再取历史最高利润
            max = Math.max(max, prices[i] - min);
            // 计算今日史低价格
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}