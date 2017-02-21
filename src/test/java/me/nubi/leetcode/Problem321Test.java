package me.nubi.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Problem321Test {
    @Test
    public void test() {
        Problem321 solution = new Problem321();
        int[] nums1 = new int[] {3, 4, 6, 5};
        int[] nums2 = new int[] {9, 1, 2, 5, 8, 3};
        int[] s = solution.maxNumber(nums1, nums2, 5);
        for (int i : s) {
            System.out.print(i + " ");
        }
        System.out.println();
        Assert.assertArrayEquals(new int[]{9, 8, 6, 5, 3}, s);
        //[9, 8, 6, 5, 3]

        nums1 = new int[] {6, 7};
        nums2 = new int[] {6, 0, 4};
        s = solution.maxNumber(nums1, nums2, 5);
        for (int i : s) {
            System.out.print(i + " ");
        }
        System.out.println();
        Assert.assertArrayEquals(new int[]{6, 7, 6, 0, 4}, s);
        //[6, 7, 6, 0, 4]

        nums1 = new int[] {3, 9};
        nums2 = new int[] {8, 9};
        s = solution.maxNumber(nums1, nums2, 3);
        for (int i : s) {
            System.out.print(i + " ");
        }
        System.out.println();
        Assert.assertArrayEquals(new int[]{9, 8, 9}, s);
        //[9, 8, 9]

        nums1 = new int[] {6,7,5};
        nums2 = new int[] {4,8,1};
        s = solution.maxNumber(nums1, nums2, 3);
        for (int i : s) {
            System.out.print(i + " ");
        }
        System.out.println();
        Assert.assertArrayEquals(new int[]{8,7,5}, s);
        //[8,6,7]
        //Expected:[8,7,5]

        nums1 = new int[] {3,3,1,8,2,4,2,9,2,4,7,1,9,2,3,4,0,7,5,4};
        nums2 = new int[] {9,7,7,1,3,6,8,6,9,6,0,4,3,6,6,1,0,4,6,2,2,6,4,6,0,4,9,7,4,9,8,4,9,8,4,6,6,5,8,2,8,6,6,6,1,0,9,0,8,0,4,0,4,4,1,7,9,8,4,2,2,0,3,2,3,9,1,8,9,5,2,7,9,2,7,7,8,5,4,4,8,6,5,5,9,6,1,4,6,0,8,5,3,4,2,0,0,9,5,2};
        s = solution.maxNumber(nums1, nums2, 100);
        for (int i : s) {
            System.out.print(i + " ");
        }
        System.out.println();
        Assert.assertArrayEquals(new int[]{9,9,9,9,6,4,6,6,2,3,4,1,0,7,5,4,0,4,6,2,2,6,4,6,0,4,9,7,4,9,8,4,9,8,4,6,6,5,8,2,8,6,6,6,1,0,9,0,8,0,4,0,4,4,1,7,9,8,4,2,2,0,3,2,3,9,1,8,9,5,2,7,9,2,7,7,8,5,4,4,8,6,5,5,9,6,1,4,6,0,8,5,3,4,2,0,0,9,5,2}, s);

        //[3,3,1,8,2,4,2,9,2,4,7,1,9,2,3,4,0,7,5,4]
        //[9,7,7,1,3,6,8,6,9,6,0,4,3,6,6,1,0,4,6,2,2,6,4,6,0,4,9,7,4,9,8,4,9,8,4,6,6,5,8,2,8,6,6,6,1,0,9,0,8,0,4,0,4,4,1,7,9,8,4,2,2,0,3,2,3,9,1,8,9,5,2,7,9,2,7,7,8,5,4,4,8,6,5,5,9,6,1,4,6,0,8,5,3,4,2,0,0,9,5,2]
        //100

        nums1 = new int[] {2,5,6,4,4,0};
        nums2 = new int[] {7,3,8,0,6,5,7,6,2};
        s = solution.maxNumber(nums1, nums2, 15);
        for (int i : s) {
            System.out.print(i + " ");
        }
        Assert.assertArrayEquals(new int[]{7,3,8,2,5,6,4,4,0,6,5,7,6,2,0}, s);
        System.out.println();
        //[2,5,6,4,4,0]
        //[7,3,8,0,6,5,7,6,2]
        //15
        // Output:  [7,3,8,2,5,6,4,4,0,0,6,5,7,6,2]
        //Expected: [7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]

        nums1 = new int[] {5,7,7,0,1,6,7,2,2,4,6,8,9,2,0,9,8,7,6,3,9,4,8,8,4,5,3,3,7,4,3,2,8,9,8,4,0,2,0,2,2,0,4,2,2,8,6,7,1,0,8,7,5,4,6,4,1,7,4,4,3,7,5,8,8,0,3,1,3,4,6,0,6,9,6,6,4,2,1,9,3,7,4,4,4,2,1,9,5,2,1,7,6,0,1,3,5,3,7,7};
        nums2 = new int[] {8,3,7,8,6,9,1,5,5,0,5,2,8,7,8,3,3,7,9,2};
        s = solution.maxNumber(nums1, nums2, 100);
        for (int i : s) {
            System.out.print(i + " ");
        }
        System.out.println();
        Assert.assertArrayEquals(new int[]{9,9,9,8,8,8,7,8,6,9,4,5,3,3,7,4,3,2,8,9,8,4,1,5,5,0,5,2,8,7,8,3,3,7,9,2,0,2,0,2,2,0,4,2,2,8,6,7,1,0,8,7,5,4,6,4,1,7,4,4,3,7,5,8,8,0,3,1,3,4,6,0,6,9,6,6,4,2,1,9,3,7,4,4,4,2,1,9,5,2,1,7,6,0,1,3,5,3,7,7}, s);

        //[5,7,7,0,1,6,7,2,2,4,6,8,9,2,0,9,8,7,6,3,9,4,8,8,4,5,3,3,7,4,3,2,8,9,8,4,0,2,0,2,2,0,4,2,2,8,6,7,1,0,8,7,5,4,6,4,1,7,4,4,3,7,5,8,8,0,3,1,3,4,6,0,6,9,6,6,4,2,1,9,3,7,4,4,4,2,1,9,5,2,1,7,6,0,1,3,5,3,7,7]
        //[8,3,7,8,6,9,1,5,5,0,5,2,8,7,8,3,3,7,9,2]
        //100
    }
}