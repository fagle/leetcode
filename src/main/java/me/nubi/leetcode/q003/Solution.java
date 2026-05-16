package me.nubi.leetcode.q003;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by fagle on 2017/3/30.
 * 3. Longest Substring Without Repeating Characters
 */
public class Solution {



        public int lengthOfLongestSubstring(String s) {
            List<Character> list = new ArrayList<>(s.length());
            int max=0;
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                int idx = list.indexOf(c);
                if (idx == -1)
                    list.add(c);
                else {
                    list.add(c);
                    list.subList(0, idx + 1).clear();
                }
                int len = list.size();
                if (len > max)
                    max = len;
            }
            return max;
        }
}
