package me.nubi.leetcode.q438;

import org.junit.Test;

public class Q438Test {

    @Test
    public void test() {
        Solution2 sol = new Solution2();
        String str = "cbaebabacd";
        String p = "abc";
        System.out.println("result=" + sol.findAnagrams(str, p));
    }
}
