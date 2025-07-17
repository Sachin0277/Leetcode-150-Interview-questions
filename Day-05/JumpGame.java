
public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // If we can't reach this index, return false
            maxReach = Math.max(maxReach, i + nums[i]); // Update the maximum reachable index
            if (maxReach >= nums.length - 1) return true; // If we can reach or exceed the last index, return true
        }
        return false; // If we finish the loop without reaching the last index, return false
    }
    // Brute-force approach: Try all possible jumps
    public boolean canJumpBruteForce(int[] nums) {
        return canJumpFromPosition(nums, 0);
    }
    private boolean canJumpFromPosition(int[] nums, int position) {
        if (position >= nums.length - 1) return true; // If we are at or beyond the last index, return true
        int furthestJump = Math.min(position + nums[position], nums.length - 1); // Calculate the furthest jump from current position
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nums, nextPosition)) {
                return true; // If any jump leads to a successful path, return true
            }
        }
        return false; // If no jumps lead to success, return false
    }

    //Use dp to solve the problem
    //explanation of this approach:
    //We create a boolean array dp where dp[i] indicates whether we can reach index i
    //We initialize dp[0] to true since we can always start at the first index
    //We iterate through the array and for each index, if we can reach it (dp[i] is true),
    //we mark all indices that can be reached from it as true
    //Time complexity: O(n^2) in the worst case
    //Space complexity: O(n) for the dp array

    public boolean canJumpDP(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true; // We can always start at the first index
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) { // If we can reach this index
                for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                    dp[i + j] = true; // Mark all reachable indices from here as true
                }
            }
        }
        return dp[nums.length - 1]; // Return whether we can reach the last index
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] nums = {2, 3, 1, 1, 4};
        boolean canJump = solution.canJump(nums);
        System.out.println("Can jump to the last index: " + canJump);
        // Test brute-force approach
        boolean canJumpBruteForce = solution.canJumpBruteForce(nums);
        System.out.println("Can jump to the last index (Brute Force): " + canJumpBruteForce);
        // Test dynamic programming approach
        boolean canJumpDP = solution.canJumpDP(nums);
        System.out.println("Can jump to the last index (DP): " + canJumpDP);
        // Additional test case
        int[] nums2 = {3, 2, 1, 0, 4};
        boolean canJump2 = solution.canJump(nums2);


        System.out.println("Can jump to the last index (Test Case 2): " + canJump2);
        boolean canJumpBruteForce2 = solution.canJumpBruteForce(nums2);
        System.out.println("Can jump to the last index (Brute Force Test Case 2): " + canJumpBruteForce2);
        boolean canJumpDP2 = solution.canJumpDP(nums2);
        System.out.println("Can jump to the last index (DP Test Case 2): " + canJumpDP2);
    }
    
}
