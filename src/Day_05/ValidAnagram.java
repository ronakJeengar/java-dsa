package Day_05;

/*
 Problem: Valid Anagram
 Category: Strings
 Day: 05
 Platform: LeetCode

 Description:
 Check if two strings are anagrams.

 Example:
 Input:  s = "anagram", t = "nagaram"
 Output: true

 Approaches:
 1. Sorting method
 2. Frequency array (optimal)

 Time Complexity: O(n)
 Space Complexity: O(1)

 Concepts:
 - Frequency counting
 - ASCII indexing

*/

import java.util.Arrays;

public class ValidAnagram {

    // Approach 1: Sort both → O(n log n)
    public static boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }

    // Approach 2: Frequency array → O(n) ✅ OPTIMAL
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26]; // only lowercase letters

        // Increment for s, decrement for t
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // If anagram, all frequencies should be 0
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
        System.out.println(isAnagram("listen", "silent"));   // true
    }
}