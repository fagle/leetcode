package me.nubi.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by fagle on 2017/3/31.
 */
public class Problem004 {
    public class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double median=0;
            int total = nums1.length + nums2.length;
            int idx = total / 2;
            int[] nums = new int[idx+1];
            int i=0, j=0;
            for (int k=0; k<=idx; k++) {
                if (i>=nums1.length && j<nums2.length)
                    nums[k] = nums2[j++];
                else if (i<nums1.length && j>=nums2.length)
                    nums[k] = nums1[i++];
                else if (i>=nums1.length && j>=nums2.length)
                    break;
                else if (nums1[i] > nums2[j])
                    nums[k] = nums2[j++];
                else
                    nums[k] = nums1[i++];
            }
            if (total % 2 == 1)
                median = nums[nums.length-1];
            else
                median = (nums[nums.length-1] + nums[nums.length-2]) / 2.0;
            return median;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums1 = new int[] {1, 3};
        int[] nums2 = new int[] {2};
        double delta = 0.00001;
        Assert.assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), delta);
        nums1 = new int[] {1, 2};
        nums2 = new int[] {3, 4};
        Assert.assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), delta);
    }
}
