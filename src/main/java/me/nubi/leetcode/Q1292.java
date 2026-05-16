package me.nubi.leetcode;

public class Q1292 {
    public static class Solution {
        public int maxSideLength(int[][] mat, int threshold) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] p = new int[m + 1][n + 1];
            p[0][0] = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    p[i][j] = mat[i - 1][j - 1] + p[i][j - 1] + p[i - 1][j] - p[i - 1][j - 1];
                }
            }
            int maxSum = 0;
            int c = 0;
            if (mat[0][0] <= threshold) {
                c = 1;
                maxSum = mat[0][0];
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int len = c + 1; len <= Math.min(m, n) && i + len - 1 <= m && j + len - 1 <= n; len++) {
                        int sum = p[i + len - 1][j + len - 1] - p[i + len - 1][j - 1] - p[i - 1][j + len - 1] + p[i - 1][j - 1];
                        if (sum > threshold) {
                            break;
                        } else if (sum > maxSum) {
                            c = len;
                        }
                    }
                }
            }
            return c;
        }
    }
}
