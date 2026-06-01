package me.nubi.leetcode.q005;

class Solution3 {
    Boolean[][] validArr = null;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        validArr = new Boolean[s.length()][s.length()];
        int max = 1;
        String maxS = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + max; j < s.length(); j++) {
                if (isValid(s, i, j)) {
                    max = j - i + 1;
                    maxS = s.substring(i, j + 1);
                }
            }
        }
        return maxS;
    }

    private boolean isValid(String s, int left, int right) {
        if (left < 0 || left>right || right > s.length() - 1) {
            return false;
        }
        if (validArr[left][right] != null) {
            return validArr[left][right];
        }
        boolean result = false;
        boolean eq = s.charAt(left) == s.charAt(right);
        if (left == right || right - left == 1 && eq) {
            result = true;
        } else if (isValid(s, left + 1, right - 1) && eq) {
            result = true;
        }
        validArr[left][right] = result;
        return result;
    }
}
