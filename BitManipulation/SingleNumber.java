package BitManipulation;
public class SingleNumber {
    public static int single(int[] a) {
        int r = 0; for (int x : a) r ^= x; return r;
    }
    public static void main(String[] args) { System.out.println(single(new int[]{2,2,1})); }
}
