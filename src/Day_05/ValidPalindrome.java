package Day_05;

/*
 Problem: Valid Palindrome
 Category: Strings
 Day: 05
 Platform: LeetCode

 Description:
 Check if a string is palindrome
 ignoring non-alphanumeric characters.

 Example:
 Input: "A man, a plan, a canal: Panama"
 Output: true

 Approach:
 Two Pointer technique.
 Skip invalid characters.
 Compare characters case-insensitively.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric from left
            while (left < right
                    && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric from right
            while (left < right
                    && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare (case-insensitive)
            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // "A man, a plan, a canal: Panama"
        System.out.println(isPalindrome(
                "A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome(" "));          // true
    }
}