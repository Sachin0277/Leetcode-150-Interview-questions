public class RemoveDuplicateFromSortedArrayII {
    /**
     * Removes duplicates from a sorted array such that each element appears at most twice.
     * Modifies the input array in-place and returns the new length.
     *
     * @param nums the sorted input array
     * @return the length of the array after removing extra duplicates
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length; // Arrays of length 2 or less are already valid
        int k = 2; // Pointer for the next position to fill
        for (int i = 2; i < nums.length; i++) {
            // If current element is not the same as the element two places before,
            // it means it can be included (at most twice allowed)
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArrayII solution = new RemoveDuplicateFromSortedArrayII();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int newLength = solution.removeDuplicates(nums);
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
