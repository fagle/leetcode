package me.nubi.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Problem004Test {

    @Test
    public void test() {
        Problem004.Solution solution = new Problem004.Solution();
        int[] nums1 = new int[] {1, 3};
        int[] nums2 = new int[] {2};
        double delta = 0.00001;
        Assert.assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), delta);
        nums1 = new int[] {1, 2};
        nums2 = new int[] {3, 4};
        Assert.assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), delta);
    }
}
