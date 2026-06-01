package me.nubi.leetcode.q005;

class Solution2 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int max = 1;
        String maxS = s.substring(0,1);
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + max; j <= s.length(); j++) {
                if (isValid(s.substring(i, j))) {
                    max = j-i+1;
                    maxS = s.substring(i,j);
                }
            }
        }
        return maxS;
    }

    private boolean isValid(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == s.charAt(right) && left<right) {
            left++;
            right--;
        }
        return left >= right;
    }
}