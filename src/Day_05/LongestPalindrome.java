package Day_05;

/*
 Problem: Longest Palindromic Substring
 Category: Strings
 Day: 05
 Platform: LeetCode

 Description:
 Find the longest substring
 that reads the same forward and backward.

 Example:
 Input: "babad"
 Output: "bab" or "aba"

 Approach:
 Expand Around Center technique.

 Check:
 - Odd length palindrome
 - Even length palindrome

 Time Complexity: O(n²)
 Space Complexity: O(1)
*/

public class LongestPalindrome {

    // Expand Around Center approach — O(n²) time, O(1) space
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0; // start index of longest palindrome
        int maxLen = 1; // length of longest palindrome

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome (center = single char)
            int len1 = expandFromCenter(s, i, i);

            // Case 2: Even length palindrome (center = between chars)
            int len2 = expandFromCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            // Update if found longer palindrome
            if (len > maxLen) {
                maxLen = len;
                // Calculate start index from center
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    // Expand outward from center, return length of palindrome
    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;   // expand left
            right++;  // expand right
        }
        // Length = right - left - 1
        // (because we went one step too far)
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // "bab" or "aba"
        System.out.println(longestPalindrome("cbbd"));  // "bb"
        System.out.println(longestPalindrome("racecar")); // "racecar"
        System.out.println(longestPalindrome("abcba"));   // "abcba"
    }
}