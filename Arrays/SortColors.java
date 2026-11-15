package Arrays;
public class SortColors {
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) { int t = nums[low]; nums[low++] = nums[mid]; nums[mid++] = t; }
            else if (nums[mid] == 1) mid++;
            else { int t = nums[mid]; nums[mid] = nums[high]; nums[high--] = t; }
        }
    }
    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0}; sortColors(a);
        for (int x : a) System.out.print(x + " ");
    }
}
