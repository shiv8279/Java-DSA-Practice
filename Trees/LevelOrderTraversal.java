package Trees;
import java.util.*;
public class LevelOrderTraversal {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    public static List<List<Integer>> levelOrder(TreeNode r) {
        List<List<Integer>> res = new ArrayList<>(); if (r == null) return res;
        Queue<TreeNode> q = new LinkedList<>(); q.offer(r);
        while (!q.isEmpty()) {
            int sz = q.size(); List<Integer> lvl = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll(); lvl.add(n.val);
                if (n.left != null) q.offer(n.left); if (n.right != null) q.offer(n.right);
            }
            res.add(lvl);
        }
        return res;
    }
    public static void main(String[] args) { System.out.println(levelOrder(new TreeNode(1))); }
}
