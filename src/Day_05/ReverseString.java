package Day_05;

/*

 Problem: Reverse String
 Category: Strings
 Day: 05
 Platform: LeetCode

 Description:
 Reverse a character array in-place.

 Example:
 Input:  ['h','e','l','l','o']
 Output: ['o','l','l','e','h']

 Approach:
 Two Pointer technique.
 Swap characters from both ends.

 Time Complexity: O(n)
 Space Complexity: O(1)

*/

public class ReverseString {

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    // Bonus: Reverse a String using StringBuilder
    public static String reverseStr(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(new String(s)); // olleh

        System.out.println(reverseStr("DSA")); // ASD
    }
}