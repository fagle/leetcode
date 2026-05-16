package me.nubi.leetcode.q042;

import me.nubi.leetcode.q042.Solution;
import org.junit.Test;

public class Q042Test {

    @Test
    public void test() {
        int[] height = new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 };
        Solution s = new Solution();
        int result = s.trap(height);
        System.out.println("result=" + result);
    }
}
