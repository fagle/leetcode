package me.nubi.leetcode.q104;

import me.nubi.leetcode.type.TreeNode;

public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
