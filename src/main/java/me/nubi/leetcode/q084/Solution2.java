package me.nubi.leetcode.q084;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int[] h = new int[len + 1];
        System.arraycopy(heights, 0, h, 0, len);
        int max = 0;
        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, (i - left - 1) * height);
            }
            stack.push(i);
        }
        return max;
    }
}