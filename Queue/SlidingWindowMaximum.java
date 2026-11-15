package Queue;
import java.util.*;
public class SlidingWindowMaximum {
    public static int[] maxSliding(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int[] res = new int[nums.length - k + 1]; int idx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) q.poll();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            q.offer(i);
            if (i >= k - 1) res[idx++] = nums[q.peek()];
        }
        return res;
    }
    public static void main(String[] args) { System.out.println(maxSliding(new int[]{1,3,-1,-3,5}, 3).length); }
}
