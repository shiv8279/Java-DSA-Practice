package Stack;
import java.util.*;
public class NextGreaterElement {
    public static int[] nextGreater(int[] nums) {
        int[] res = new int[nums.length]; Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]) s.pop();
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
    public static void main(String[] args) { System.out.println(nextGreater(new int[]{4,5,2})[0]); }
}
