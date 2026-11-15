package BitManipulation;
public class NumberOf1Bits {
    public static int hamming(int n) {
        int c = 0; while (n != 0) { n &= (n - 1); c++; } return c;
    }
    public static void main(String[] args) { System.out.println(hamming(11)); }
}
