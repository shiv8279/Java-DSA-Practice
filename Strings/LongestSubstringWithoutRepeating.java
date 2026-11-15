package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println("Longest Substring: " + lengthOfLongestSubstring("abcabcbb"));
    }
}
