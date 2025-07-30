public class ContainerWithMostWater {
    private int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * currentHeight);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
    private int maxAreaBruteForce(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int currentHeight = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, width * currentHeight);
            }
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,1};

        System.out.println(container.maxArea(height1)); // 49
        System.out.println(container.maxArea(height2)); // 1
        System.out.println(container.maxAreaBruteForce(height1)); // 49
        System.out.println(container.maxAreaBruteForce(height2)); // 1
    }
}
