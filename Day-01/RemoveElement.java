public class RemoveElement {
    // Removes all instances of 'val' from the array using the two-pointer approach.
    // The method modifies the array in-place and returns the new length.
    public int removeElementOptimized(int[] nums, int val) {
        int left = 0; // Pointer to scan the array from the start
        int right = nums.length - 1; // Pointer to scan the array from the end

        while (left <= right) {
            if (nums[left] == val) {
                // If current element equals val, replace it with the element at 'right'
                nums[left] = nums[right];
                right--; // Reduce the array size by moving 'right' leftwards
                // Do not increment 'left' here, as the swapped element needs to be checked
            } else {
                left++; // Move to the next element if current is not val
            }
        }
        // 'left' is the new length of the array after removal
        return left;
    }

    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for the position of the next valid element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i]; // Place valid elements at the front
            }
        }
        return k; // Return the new length of the array
    }

    public static void main(String[] args) {
        RemoveElement remover = new RemoveElement();
        int[] nums = { 3, 2, 2, 3 };
        int val = 3;

        int newLength = remover.removeElement(nums, val);

        System.out.print("Array after removal: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    
}
