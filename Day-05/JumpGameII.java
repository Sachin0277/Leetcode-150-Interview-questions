
public class JumpGameII {
    // Greedy approach to solve the problem
    // We keep track of the maximum reachable index at each step
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0; // If the array has one or no elements, no jumps are needed
        int jumps = 0; // Number of jumps made
        int currentEnd = 0; // The farthest index we can reach with the current number of jumps
        int farthest = 0; // The farthest index we can reach with the next jump

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // Update the farthest index we can reach
            if (i == currentEnd) { // If we have reached the end of the current jump
                jumps++; // Increment the jump count
                currentEnd = farthest; // Update the end of the current jump to the farthest reachable index
            }
        }
        return jumps;
    }
    // Brute-force approach: Try all possible jumps
    public int jumpBruteForce(int[] nums) {
        return jumpFromPosition(nums, 0);
    }

    public int jumpFromPosition(int[] nums, int position) {
        if (position >= nums.length - 1) return 0; // If we are at or beyond the last index, no jumps needed
        int minJumps = Integer.MAX_VALUE; // Initialize minimum jumps to a large value
        int furthestJump = Math.min(position + nums[position], nums.length - 1); // Calculate the furthest jump from current position

        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            int jumps = jumpFromPosition(nums, nextPosition); // Recursively calculate jumps from the next position
            if (jumps != Integer.MAX_VALUE) { // If we can reach the end from this position
                minJumps = Math.min(minJumps, jumps + 1); // Update minimum jumps
            }
        }
        return minJumps; // Return the minimum jumps needed to reach the end
    }
    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();
        int[] nums = {2, 3, 1, 1, 4};
        int jumps = solution.jump(nums);
        System.out.println("Minimum jumps to reach the last index: " + jumps);
        // Test brute-force approach
        int jumpsBruteForce = solution.jumpBruteForce(nums);
        System.out.println("Minimum jumps to reach the last index (Brute Force): " + jumpsBruteForce);
    }
    
}
