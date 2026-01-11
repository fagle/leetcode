package me.nubi.leetcode;

/**
 * Created by fagle on 2017/3/31.
 */
public class Problem004 {
    public static class Solution {
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

}
