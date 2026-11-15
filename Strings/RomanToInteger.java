package Strings;
import java.util.*;
public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> m = Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = m.get(s.charAt(i));
            if (i + 1 < s.length() && v < m.get(s.charAt(i + 1))) total -= v;
            else total += v;
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
