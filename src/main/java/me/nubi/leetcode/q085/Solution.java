package me.nubi.leetcode.q085;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

        @SuppressWarnings("unchecked")
        public int maximalRectangle(char[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int max = 0;
            int[][] left = new int[rows][cols];
            int[][] area = new int[rows][cols];
            Deque<Integer>[] deque = new ArrayDeque[cols];
            for (int k = 0; k < cols; k++) {
                deque[k] = new ArrayDeque<>();
                deque[k].addLast(-1);
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == '1') {
                        if (j > 0) {
                            left[i][j] = left[i][j-1] + 1;
                        } else {
                            left[i][j] = 1;
                        }
                    }
                    if (matrix[i][j] == '0') {
                        left[i][j] = 0;
                    }
                    int last = deque[j].peekLast();

                    while (last > -1) {
                        if (left[i][j] < left[last][j]) {
                            last = deque[j].removeLast();
                            area[last][j] = left[last][j] * (i - deque[j].peekLast() - 1);
                            max = Math.max(max, area[last][j]);
                            last = deque[j].peekLast();
                        } else {
                            break;
                        }
                    }
                    deque[j].addLast(i);
                }
            }
            for (int j=0; j < cols; j++) {
                while (deque[j].peekLast() > -1) {
                    int last = deque[j].removeLast();
                    area[last][j] = left[last][j] * (rows - deque[j].peekLast() -1);
                    max = Math.max(max, area[last][j]);
                }
            }
            return max;
        }
}
