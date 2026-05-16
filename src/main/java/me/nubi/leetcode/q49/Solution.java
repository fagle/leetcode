package me.nubi.leetcode.q49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = baseSort(s);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String baseSort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (char i=0; i< arr.length; i++) {
            if (arr[i] > 0) {
                for (int j=0; j< arr[i]; j++) {
                    sb.append((char)(i+'a'));
                }
            }
        }
        return sb.toString();
    }
}