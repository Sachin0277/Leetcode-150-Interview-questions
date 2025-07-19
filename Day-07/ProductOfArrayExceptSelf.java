

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;

        // Calculate prefix products
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;
        // Calculate suffix products and multiply with prefix products
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }

    //Brute force approach
    public int[] productExceptSelfBruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    result[i] *= nums[j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        
        System.out.println("Product of array except self: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Brute force example
        int[] bruteForceResult = solution.productExceptSelfBruteForce(nums);
        System.out.println("\nBrute force product of array except self: ");
        for (int num : bruteForceResult) {
            System.out.print(num + " ");
        }
        //with zero
        int[] numsWithZero = {1, 2, 0, 4};
        int[] resultWithZero = solution.productExceptSelf(numsWithZero);
        System.out.println("\nProduct of array with zero except self: ");
        for (int num : resultWithZero) {
            System.out.print(num + " ");
        }
    }
    
}
