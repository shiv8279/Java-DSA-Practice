package Trees;
public class DiameterOfBinaryTree {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    static int max = 0;
    public static int diameter(TreeNode r) { max = 0; depth(r); return max; }
    static int depth(TreeNode n) {
        if (n == null) return 0;
        int l = depth(n.left), r = depth(n.right);
        max = Math.max(max, l + r);
        return 1 + Math.max(l, r);
    }
    public static void main(String[] args) { System.out.println(diameter(new TreeNode(1))); }
}
