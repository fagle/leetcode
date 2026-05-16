package me.nubi.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q42 {
    public static class Solution {
        public int trap(int[] height) {
            int len = height.length;
            if (len < 3) {
                return 0;
            }
            Deque<Integer> stack = new ArrayDeque<>();
            int count = 0;
            int bottom = 0;
            for (int i = 0; i < len; i++) {
                while (!stack.isEmpty() && height[i] > 0) {
                    int last = stack.peekLast();
                    int h = Math.min(height[last], height[i]) - bottom;
                    bottom = Math.min(height[i], height[last]);
                    int c = h * (i - last - 1);
                    count += c;
                    if (height[i] >= height[last]) {
                        stack.removeLast();
                    } else {
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    bottom = 0;
                }
                stack.addLast(i);
            }
            return count;
        }
    }

    static class Solution2 {
        public int trap(int[] height) {
            if (height.length < 3) {
                return 0;
            }
            int left = 0, right = height.length - 1;
            int maxLeft = height[0], maxRight = height[right];
            int ans = 0;
            while (left < right) {
                if (height[left] <= height[right]) {
                    ans += maxLeft - height[left];
                    left++;
                    maxLeft = Math.max(height[left], maxLeft);
                }
                if (height[left] > height[right]) {
                    ans += maxRight - height[right];
                    right--;
                    maxRight = Math.max(height[right], maxRight);
                }
            }
            return ans;
        }
    }
}


