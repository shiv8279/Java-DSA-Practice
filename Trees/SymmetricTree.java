package Trees;
public class SymmetricTree {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    public static boolean isSymmetric(TreeNode root) { return root == null || check(root.left, root.right); }
    static boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && check(t1.left, t2.right) && check(t1.right, t2.left);
    }
    public static void main(String[] args) { System.out.println(isSymmetric(new TreeNode(1))); }
}
