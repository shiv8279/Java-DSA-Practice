package Trees;

import java.util.*;

public class BinaryTreeInorder {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private static void helper(TreeNode node, List<Integer> res) {
        if (node != null) {
            helper(node.left, res);
            res.add(node.val);
            helper(node.right, res);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println("Inorder: " + inorderTraversal(root));
    }
}
