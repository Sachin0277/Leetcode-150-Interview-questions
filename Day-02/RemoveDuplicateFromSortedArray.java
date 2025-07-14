public class RemoveDuplicateFromSortedArray {
    // This method removes duplicates from a sorted array in-place and returns the new length.
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int i = 0; // Pointer for the position of unique elements
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // Move the unique element to the next position
            }
        }
        return i + 1; // Return the length of the array with unique elements
    }
       public static void main(String[] args) {
        RemoveDuplicateFromSortedArray solution = new RemoveDuplicateFromSortedArray();
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int len = solution.removeDuplicates(nums);
        System.out.println("Length after removing duplicates: " + len);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
