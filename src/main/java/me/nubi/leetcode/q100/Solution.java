package me.nubi.leetcode.q100;

import me.nubi.leetcode.type.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

class Solution {

    private final HashMap<TreeNode, Integer> nodeDepth = new HashMap<>();
    public int diameterOfBinaryTree(TreeNode root) {
        int max = 0;
        TreeNode node = root;
        if (root.left == null && root.right == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            int len = depth(node.left) + depth(node.right) + 2;
            if (len > max) {
                max = len;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (nodeDepth.containsKey(root)) {
            return nodeDepth.get(root);
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int depth = Math.max(depth(root.left), depth(root.right)) + 1;
        nodeDepth.put(root, depth);
        return depth;
    }

}
