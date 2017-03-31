package me.nubi.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by fagle on 17-3-31.
 * 5. Longest Palindromic Substring
 */
public class Problem005 {
    public class Solution {
        public String longestPalindrome(String s) {
            Queue<Character> queue = new LinkedBlockingQueue<>();
            Stack<Character> stack;
            return null;
        }
    }

    @Test
    public void test() {
        String s = "babad";
        Solution solution = new Solution();
        Assert.assertEquals("bab", solution.longestPalindrome(s));
        s = "cbbd";
        Assert.assertEquals("bb", solution.longestPalindrome(s));
    }
}
