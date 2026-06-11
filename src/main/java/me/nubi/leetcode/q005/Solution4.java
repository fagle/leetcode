package me.nubi.leetcode.q005;

class Solution4 {

    int max;
    int maxLeft;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        max = 1;
        maxLeft = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            extend(s, i, i);
            extend(s, i, i+1);
        }
        return s.substring(maxLeft, maxLeft + max);
    }

    private void extend(String s, int left, int right) {
        int len;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                len = right - left + 1;
                if (len > max) {
                    maxLeft = left;
                    max = right - left + 1;
                }
                left--;
                right++;
            } else {
                break;
            }

        }
    }
}
