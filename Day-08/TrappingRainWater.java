
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }
    // Brute force approach
    public int trapBruteForce(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int totalWater = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;

            // Find left max
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find right max
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            totalWater += Math.min(leftMax, rightMax) - height[i];
        }

        return totalWater;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = solution.trap(height);
        
        System.out.println("Trapped rainwater: " + result);
        // Brute force example
        int bruteForceResult = solution.trapBruteForce(height);
        System.out.println("Trapped rainwater using brute force: " + bruteForceResult);
        // Example with no water trapped
        int[] heightNoWater = {4, 2, 0, 3, 2, 5};
        int resultNoWater = solution.trap(heightNoWater);
        System.out.println("Trapped rainwater with no water trapped: " + resultNoWater);

    }
}
