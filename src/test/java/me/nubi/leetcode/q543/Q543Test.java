package me.nubi.leetcode.q543;

import me.nubi.leetcode.type.TreeNode;
import org.junit.Test;

public class Q543Test {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Solution sol = new Solution();
        System.out.println("result:" + sol.diameterOfBinaryTree(root));
    }
}
