package Day_02;

/*
Problem: Power of Two
Day: 02

Approaches:

1. Iterative Division
Time Complexity: O(log n)

2. Bit Manipulation Trick
Time Complexity: O(1)

Key Concept:
n & (n - 1) == 0

Concepts:
- Bit manipulation
- Binary properties
*/

public class PowerOfTwo {

    // Approach 1: Iterative — O(log n)
    public static boolean isPowerOfTwoIterative(int n) {
        if (n <= 0) return false;   // negative numbers can't be power of 2
        while (n > 1) {
            if (n % 2 != 0) return false; // odd → not power of 2
            n /= 2;
        }
        return true;
    }

    // Approach 2: Bit Trick — O(1)
    // Powers of 2 in binary: 1, 10, 100, 1000...
    // n-1 in binary:         0, 01, 011, 0111...
    // n & (n-1) is always 0 for powers of 2!
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));  // true  (2^0)
        System.out.println(isPowerOfTwo(16)); // true  (2^4)
        System.out.println(isPowerOfTwo(3));  // false
        System.out.println(isPowerOfTwo(0));  // false
    }
}
