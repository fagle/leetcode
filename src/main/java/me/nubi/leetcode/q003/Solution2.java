package me.nubi.leetcode.q003;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (queue.isEmpty() || !queue.contains(s.charAt(i))) {
                queue.add(s.charAt(i));
                max = Math.max(max, queue.size());
            } else {
                Character top;
                do  {
                    top = queue.remove();
                } while (top != s.charAt(i));
                queue.add(top);
            }
        }
        return max;
    }
}