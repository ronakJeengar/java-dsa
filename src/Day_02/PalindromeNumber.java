package Day_02;

/*
Problem: Palindrome Number
Day: 02

Check whether integer reads same forward and backward.

Optimization:
Reverse only half of the number.

Time Complexity: O(log n)
Space Complexity: O(1)

Concepts:
- Number reversal
- Mathematical operations
*/

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        // Negative numbers are never palindromes
        // Numbers ending in 0 (except 0 itself) can't be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversed = 0;

        // Only reverse HALF the number (clever optimization!)
        // Stop when reversed >= x (we've passed the midpoint)
        while (x > reversed) {
            reversed = reversed * 10 + x % 10; // take last digit of x
            x /= 10;                            // remove last digit of x
        }

        // Even length: x == reversed
        // Odd length: x == reversed/10 (middle digit doesn't matter)
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));   // true
        System.out.println(isPalindrome(-121));  // false
        System.out.println(isPalindrome(10));    // false
        System.out.println(isPalindrome(12321)); // true
    }
}

