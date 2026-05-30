package me.nubi.leetcode.q20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public boolean isValid(String s) {
        Deque<Character> d = new ArrayDeque<>();
        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        for (int i=0; i< s.length(); i++) {
            // 是个右括号
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                if (d.isEmpty() || c != map.get(d.peek())) {
                    return false;
                } else {
                    d.pop();
                }
            } else {
                d.push(c);
            }
        }
        return d.isEmpty();
    }
}