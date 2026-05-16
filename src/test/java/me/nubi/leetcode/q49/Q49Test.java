package me.nubi.leetcode.q49;

import com.alibaba.fastjson2.JSON;
import org.junit.Test;

import java.util.List;

public class Q49Test {

    @Test
    public void test1() {
         String[] sa = JSON.parseArray("[\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"]", String.class).toArray(new String[0]);
         Solution s = new Solution();
         List<List<String>> result = s.groupAnagrams(sa);
         System.out.println(result);
    }
}