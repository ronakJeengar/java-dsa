package Day_04;

/*
Problem: Two Sum
Platform: LeetCode

Description:
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution.

Example:

Input:
nums = [2,7,11,15], target = 9

Output:
[0,1]

Explanation:
nums[0] + nums[1] = 2 + 7 = 9

Approaches:

1. Brute Force
   Check all pairs.

   Time Complexity: O(n²)
   Space Complexity: O(1)

2. Optimized (HashMap)
   Store number → index.
   Check if (target - num) exists.

   Time Complexity: O(n)
   Space Complexity: O(n)

Concepts:
- HashMap
- Complement technique
- Index tracking

Day: 04
*/

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // Brute Force: O(n²)
    public static int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
        return new int[]{};
    }

    // Optimized: O(n) using HashMap
    // Key insight: for each num, check if (target - num) exists
    public static int[] twoSum(int[] nums, int target) {
        // Map: value → index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // what we need

            if (map.containsKey(complement)) {
                // Found! Return indices
                return new int[]{map.get(complement), i};
            }
            // Store current number and its index
            map.put(nums[i], i);
        }
        return new int[]{}; // no solution
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result)); // [0, 1]

        result = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(result)); // [1, 2]
    }
}

