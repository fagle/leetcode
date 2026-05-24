package me.nubi.leetcode.q101;

import me.nubi.leetcode.type.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right == null) {
            return false;
        }
        if (root.left == null) {
            return false;
        }
        List<Integer> left = leftFirst(root.left);
        List<Integer> right = rightFirst(root.right);
        return left.equals(right);
    }

    List<Integer> leftFirst(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            result.add(null);
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }
        result.add(root.val);
        result.addAll(leftFirst(root.left));
        result.addAll(leftFirst(root.right));
        return result;
    }

    List<Integer> rightFirst(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            result.add(null);
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }
        result.add(root.val);
        result.addAll(rightFirst(root.right));
        result.addAll(rightFirst(root.left));
        return result;
    }
}
