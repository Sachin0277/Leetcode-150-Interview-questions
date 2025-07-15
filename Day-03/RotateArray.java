public class RotateArray {
    // The RotateArray class is typically used to provide methods that rotate the elements
    // of an array to the right by a given number of steps. For example, rotating [1,2,3,4,5] by 2 steps
    // results in [4,5,1,2,3]. The actual implementation of the rotation logic would be added as methods
    // inside this class.
    public static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    public static void rotateArrayBruteForce(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        for (int i = 0; i < k; i++) {
            int last = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        /*
         * rotate(nums,0,nums.length-1); [5,4,3,2,1]
         * rotate(nums,0,2); [4,5,3,2,1]
         * rotate(nums,2,4); [4,5,1,2,3]
         */
        int k = 2;
        rotateArray(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
       
        System.out.println("\nBrute Force Rotation:");
        int[] nums2 = {1, 2, 3, 4, 5};
        rotateArrayBruteForce(nums2, k);
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }
}
