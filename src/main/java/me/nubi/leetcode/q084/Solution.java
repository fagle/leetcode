package me.nubi.leetcode.q084;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return heights[0];
            }
            int[] newHeight = new int[len + 2];
            for (int i = 0; i < len; i++) {
                newHeight[i + 1] = heights[i];
            }
            heights = newHeight;
            len = len + 2;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.addLast(0);
            int max = 0;
            for (int i=1; i< len; i++) {
                while (heights[stack.peekLast()] > heights[i]) {
                    int height = heights[stack.removeLast()];
                    int width = i - stack.peekLast() - 1;
                    int area = height * width;
                    max = Math.max(area, max);
                }
                stack.addLast(i);
            }
            return max;
        }

}
