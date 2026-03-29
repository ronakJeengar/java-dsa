package Day_04;

/*
Problem: Contains Duplicate
Platform: LeetCode

Description:
Given an integer array nums,
return true if any value appears
at least twice in the array.

Return false if every element is distinct.

Example:

Input:  [1,2,3,1]
Output: true

Input:  [1,2,3,4]
Output: false

Approaches:

1. Brute Force
   Compare every pair.
   Time: O(n²)

2. Optimized (HashSet)
   Store elements in a HashSet.
   If element already exists → duplicate found.

   Time: O(n)
   Space: O(n)

Concepts:
- HashSet
- Duplicate detection
- Time optimization

Day: 04
*/

import java.util.HashSet;

public class ContainsDuplicate {

    // Brute Force: O(n²) — check all pairs
    public static boolean containsDuplicateBrute(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] == nums[j]) return true;
        return false;
    }

    // Optimized: O(n) using HashSet
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) return true; // already seen!
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1})); // true
        System.out.println(containsDuplicate(new int[]{1,2,3,4})); // false
    }
}

