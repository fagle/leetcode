package me.nubi.leetcode.q543;

import me.nubi.leetcode.type.TreeNode;

public class Solution2 {

    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        TreeNode node = root;
        if (root.left == null && root.right == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        int len = left + right;
        if (len > max) {
            max = len;
        }
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        int len = left + right;
        if (len > max) {
            max = len;
        }
        return Math.max(left, right) + 1;
    }
}
