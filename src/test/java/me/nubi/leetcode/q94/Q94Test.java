package me.nubi.leetcode.q94;

import me.nubi.leetcode.type.TreeNode;
import org.junit.Test;

import java.util.List;

public class Q94Test {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution2 sol = new Solution2();
        List<Integer> result = sol.inorderTraversal(root);
        System.out.println("result=" + result);
    }
}
