package Day_03;

import java.util.Arrays;

/*
Problem: Largest Number
Platform: LeetCode

Description:
Given a list of non-negative integers,
arrange them such that they form the largest number.

Example:

Input:  [3, 30, 34, 5, 9]
Output: "9534330"

Input:  [10, 2]
Output: "210"

Approach:

1. Convert numbers to strings
2. Sort using custom comparator:
   Compare (b + a) vs (a + b)
3. Join all strings
4. Handle edge case (all zeros)

Why Comparator Works:

"9" + "34" = "934"
"34" + "9" = "349"

Since "934" > "349"
→ "9" should come first.

Time Complexity:
O(n log n)

Space Complexity:
O(n)

Concepts:
- Comparator
- Custom Sorting
- String Manipulation
- Greedy Ordering

Day: 03
*/

public class LargestNumber {

    public static String largestNumber(int[] nums) {

        // Convert integers to strings
        String[] strNums = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom sort
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if highest is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build result
        StringBuilder result = new StringBuilder();

        for (String s : strNums) {
            result.append(s);
        }

        return result.toString();
    }

    // Test
    public static void main(String[] args) {

        int[] nums1 = {3, 30, 34, 5, 9};
        int[] nums2 = {10, 2};

        System.out.println(largestNumber(nums1)); // 9534330
        System.out.println(largestNumber(nums2)); // 210
    }
}

