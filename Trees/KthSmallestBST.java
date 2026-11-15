package Trees;
import java.util.*;
public class KthSmallestBST {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>(); TreeNode c = root;
        while (c != null || !s.isEmpty()) {
            while (c != null) { s.push(c); c = c.left; }
            c = s.pop();
            if (--k == 0) return c.val;
            c = c.right;
        }
        return -1;
    }
    public static void main(String[] args) { System.out.println(kthSmallest(new TreeNode(1), 1)); }
}
