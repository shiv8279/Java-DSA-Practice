package Strings;
public class StringCompression {
    public static int compress(char[] chars) {
        int idx = 0, i = 0;
        while (i < chars.length) {
            char cur = chars[i]; int count = 0;
            while (i < chars.length && chars[i] == cur) { i++; count++; }
            chars[idx++] = cur;
            if (count > 1) for (char c : Integer.toString(count).toCharArray()) chars[idx++] = c;
        }
        return idx;
    }
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }
}
