package Trees;
public class LowestCommonAncestor {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    public static TreeNode lca(TreeNode r, TreeNode p, TreeNode q) {
        if (r == null || r == p || r == q) return r;
        TreeNode l = lca(r.left, p, q), right = lca(r.right, p, q);
        return (l != null && right != null) ? r : (l != null ? l : right);
    }
    public static void main(String[] args) { System.out.println(lca(new TreeNode(1), null, null)); }
}
