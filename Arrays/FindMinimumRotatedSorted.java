package Arrays;
public class FindMinimumRotatedSorted {
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) l = m + 1;
            else r = m;
        }
        return nums[l];
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,6,1,2}));
    }
}
