package Day_03;

import java.util.Arrays;

/*
Problem: Sort Array By Parity
Platform: LeetCode

Description:
Given an integer array nums, move all even integers
to the beginning of the array followed by all odd integers.

Return any valid result.

Example:
Input:  [3, 1, 2, 4]
Output: [4, 2, 1, 3] or [2, 4, 3, 1]

Approach:
Use Two Pointer Technique.

- left pointer moves forward
- right pointer moves backward
- swap odd element on left with even element on right

Time Complexity: O(n)
Space Complexity: O(1)

Concepts:
- Two pointers
- Array partitioning
- Swapping elements

Day: 03
*/

public class SortArrayByParity {

    // Two-pointer solution
    public static int[] sortArrayByParity(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            // Move left until odd found
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }

            // Move right until even found
            while (left < right && nums[right] % 2 != 0) {
                right--;
            }

            // Swap
            if (left < right) {

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

        return nums;
    }

    // Test method
    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 4};

        int[] result = sortArrayByParity(nums);

        System.out.println(Arrays.toString(result));
    }
}