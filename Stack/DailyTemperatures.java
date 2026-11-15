package Stack;
import java.util.*;
public class DailyTemperatures {
    public static int[] daily(int[] t) {
        int[] ans = new int[t.length]; Stack<Integer> s = new Stack<>();
        for (int i = 0; i < t.length; i++) {
            while (!s.isEmpty() && t[i] > t[s.peek()]) { int prev = s.pop(); ans[prev] = i - prev; }
            s.push(i);
        }
        return ans;
    }
    public static void main(String[] args) { System.out.println(daily(new int[]{73,74,75})[0]); }
}
