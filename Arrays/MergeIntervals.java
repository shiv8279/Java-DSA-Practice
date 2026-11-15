package Arrays;
import java.util.*;
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>(); int[] curr = intervals[0]; res.add(curr);
        for (int[] inv : intervals) {
            if (inv[0] <= curr[1]) curr[1] = Math.max(curr[1], inv[1]);
            else { curr = inv; res.add(curr); }
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        System.out.println(merge(new int[][]{{1,3},{2,6}}).length);
    }
}
