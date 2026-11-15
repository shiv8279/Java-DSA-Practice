package Searching;

public class FirstAndLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{find(nums, target, true), find(nums, target, false)};
    }
    private static int find(int[] nums, int target, boolean first) {
        int l = 0, r = nums.length - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                ans = m;
                if (first) r = m - 1; else l = m + 1;
            } else if (nums[m] < target) l = m + 1; else r = m - 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] r = searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(r[0] + ", " + r[1]);
    }
}
