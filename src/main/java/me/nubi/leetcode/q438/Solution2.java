package me.nubi.leetcode.q438;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] counts = new int[26];
        for (int i = 0; i < p.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            counts[p.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) { diff++; }
        }
        if (diff == 0) {
            result.add(0);
        }
        for (int i=0; i + p.length() < s.length(); i++) {
            char left = s.charAt(i);
            char right = s.charAt(i + p.length());
            if (counts[left-'a'] == 0) {
                diff++;
            } else if (counts[left-'a'] == 1) {
                diff--;
            }
            counts[left-'a']--;
            if (counts[right-'a'] == 0) {
                diff++;
            } else  if (counts[right-'a'] == -1) {
                diff--;
            }
            counts[right-'a']++;
            if (diff == 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}