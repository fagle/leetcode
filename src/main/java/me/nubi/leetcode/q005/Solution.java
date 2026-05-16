package me.nubi.leetcode.q005;


/**
 * Created by fagle on 17-3-31.
 * 5. Longest Palindromic Substring
 */
public class Solution {

        public String longestPalindrome(String s) {
            int max=0, i1=0, j1=0;
            for (int k=0; k < s.length(); k++) {
                for (int i=k-1,j=k+1; i>=0 && j<s.length(); i--,j++) {
                     if (s.charAt(i) == s.charAt(j)) {
                         int len = j-i+1;
                         if (len > max) {
                             max = len;
                             i1 = i;
                             j1 = j;
                         }
                     } else {
                         break;
                     }
                }
                for (int i=k,j=k+1; i>=0 && j<s.length(); i--,j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        int len = j-i+1;
                        if (len > max) {
                            max = len;
                            i1 = i;
                            j1 = j;
                        }
                    } else {
                        break;
                    }
                }
            }
            return s.substring(i1, j1 + 1);
        }
}
