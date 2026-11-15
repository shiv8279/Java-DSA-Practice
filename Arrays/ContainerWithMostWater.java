package Arrays;
public class ContainerWithMostWater {
    public static int maxArea(int[] h) {
        int l = 0, r = h.length - 1, max = 0;
        while (l < r) {
            max = Math.max(max, Math.min(h[l], h[r]) * (r - l));
            if (h[l] < h[r]) l++; else r--;
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
