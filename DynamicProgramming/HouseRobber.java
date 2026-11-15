package DynamicProgramming;

public class HouseRobber {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int temp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 1};
        System.out.println("Max Loot: " + rob(houses));
    }
}
