package me.nubi.leetcode.q20;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> d = new ArrayDeque<>();
        if (s.length() == 1) {
            return false;
        }
        for (int i=0; i< s.length(); i++) {
            if (d.isEmpty()) {
                d.push(s.charAt(i));
                continue;
            }
            if (!isPair(d.peek(), s.charAt(i))) {
                d.push(s.charAt(i));
            } else {
                d.pop();
            }
        }
        return d.isEmpty();
    }

    private boolean isPair(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        return left == '{' && right == '}';
    }
}