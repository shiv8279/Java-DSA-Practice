package DynamicProgramming;
import java.util.*;
public class WordBreak {
    public static boolean wordBreak(String s, List<String> dict) {
        Set<String> set = new HashSet<>(dict); boolean[] dp = new boolean[s.length() + 1]; dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 0; j < i; j++)
                if (dp[j] && set.contains(s.substring(j, i))) { dp[i] = true; break; }
        return dp[s.length()];
    }
    public static void main(String[] args) { System.out.println(wordBreak("leetcode", List.of("leet", "code"))); }
}
