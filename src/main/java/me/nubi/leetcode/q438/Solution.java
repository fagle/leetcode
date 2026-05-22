package me.nubi.leetcode.q438;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        for (int i=0; i + p.length() <= s.length(); i++) {
            String sub = s.substring(i, i+p.length());
            if (alike(sub, p)) {
                result.add(i);
            }
        }
        return result;
    }

    boolean alike(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            freq2[c - 'a']++;
        }
        for (int i=0; i<26; i++) {
            if (freq1[i] != freq2[i]) { return false; }
        }
        return true;
    }
}
