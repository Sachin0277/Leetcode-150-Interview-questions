import java.util.HashMap;

public class MajorityElement {
    // Finds the majority element in the array using Boyer-Moore Voting Algorithm.
    // The majority element is the element that appears more than n/2 times.
    // Assumes that the array is non-empty and a majority element always exists.
    // Time Complexity: O(n), Space Complexity: O(1)
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int majority;
        if (n > 0) {
            majority = nums[0];
        } else {
            majority = 0;
        }
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                majority = nums[i];
            }
            if (nums[i] == majority) {
                cnt += 1;
            } else {
                cnt -= 1;
            }
        }
        return majority;

    }

    public int majorityElementBruteforce(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maj = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > maj) {
                return nums[i];
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        int result = solution.majorityElement(nums);
        int ans = solution.majorityElementBruteforce(nums);
        System.out.println("Majority element (Boyer-Moore): " + result);
        System.out.println("Majority element: " + ans);
    }
}