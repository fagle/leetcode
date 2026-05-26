package me.nubi.leetcode.q108;

import me.nubi.leetcode.type.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = start +  (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int left = mid - 1;
        if (left >= start) {
            root.left = sortedArrayToBST(nums, start, left);
        }
        int right = mid + 1;
        if (right <= end) {
            root.right = sortedArrayToBST(nums, right, end);
        }
        return root;
    }
}