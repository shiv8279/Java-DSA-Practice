package Trees;
public class ValidateBST {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    public static boolean isValidBST(TreeNode root) { return val(root, null, null); }
    static boolean val(TreeNode n, Integer lo, Integer hi) {
        if (n == null) return true;
        if ((lo != null && n.val <= lo) || (hi != null && n.val >= hi)) return false;
        return val(n.left, lo, n.val) && val(n.right, n.val, hi);
    }
    public static void main(String[] args) { System.out.println(isValidBST(new TreeNode(2))); }
}
