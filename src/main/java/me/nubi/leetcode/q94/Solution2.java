package me.nubi.leetcode.q94;

import me.nubi.leetcode.type.TreeNode;

import java.util.*;

class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(node);
        node = node.left;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;
    }
}
