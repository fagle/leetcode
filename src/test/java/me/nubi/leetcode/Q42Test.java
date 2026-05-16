package me.nubi.leetcode;

import me.nubi.leetcode.q42.Solution;
import org.junit.Test;

public class Q42Test {

    @Test
    public void test() {
        int[] height = new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 };
        Solution s = new Solution();
        int result = s.trap(height);
        System.out.println("result=" + result);
    }
}
