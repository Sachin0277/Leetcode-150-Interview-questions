public class TwoSumIIArrayIsSorted {
    private int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{-1, -1};
        }
        
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Return 1-based indices
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{-1, -1}; // No solution found
    }
    private int[] twoSumBruteForce(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{-1, -1};
        }
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1}; // Return 1-based indices
                }
            }
        }
        
        return new int[]{-1, -1}; // No solution found
    }

    private void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    private int[] twoSumBinarySearch(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{-1, -1};
        }
        
        for (int i = 0; i < numbers.length - 1; i++) {
            int complement = target - numbers[i];
            int index = binarySearch(numbers, complement, i + 1, numbers.length - 1);
            if (index != -1) {
                return new int[]{i + 1, index + 1}; // Return 1-based indices
            }
        }
        
        return new int[]{-1, -1}; // No solution found
    }
    private int binarySearch(int[] numbers, int complement, int i, int j) {
        // TODO Auto-generated method stub
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (numbers[mid] == complement) {
                return mid; // Found the complement
            } else if (numbers[mid] < complement) {
                i = mid + 1; // Search in the right half
            } else {
                j = mid - 1; // Search in the left half
            }
        }
        return -1; // Complement not found
    }
    public static void main(String[] args) {
        TwoSumIIArrayIsSorted twoSum = new TwoSumIIArrayIsSorted();
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum.twoSum(numbers1, target1);
        twoSum.printArray(result1); // Output: [1, 2]

        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        int[] result2 = twoSum.twoSum(numbers2, target2);
        twoSum.printArray(result2); // Output: [1, 3]

        int[] numbers3 = {-1, 0};
        int target3 = -1;
        int[] result3 = twoSum.twoSum(numbers3, target3);
        twoSum.printArray(result3); // Output: [1, 2]

        int[] numbers4 = {5, 25, 75};
        int target4 = 100;
        int[] result4 = twoSum.twoSum(numbers4, target4);
        twoSum.printArray(result4); // Output: [2, 3]

        int[] numbers5 = {1, 2, 3, 4, 4, 5};
        int target5 = 8;
        int[] result5 = twoSum.twoSumBinarySearch(numbers5, target5);
        twoSum.printArray(result5); // Output: [4, 5]

    
        int[] result6 = twoSum.twoSum(numbers5, target5);
        twoSum.printArray(result6); // Output: [4, 5]

    }
}
