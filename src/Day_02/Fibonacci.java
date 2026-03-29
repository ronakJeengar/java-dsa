package Day_02;

/*
Problem: Fibonacci Sequence
Day: 02

Approaches:

1. Recursive
Time Complexity: O(2^n)
Space Complexity: O(n)

2. Iterative (Optimal)
Time Complexity: O(n)
Space Complexity: O(1)

Concepts:
- Recursion
- Iterative DP logic
*/

public class Fibonacci {

    // Approach 1: Recursive (clean but slow)
    // Time: O(2^n) — exponential! Don't use for large n
    public static int fibRecursive(int n) {
        if (n <= 0) return 0;      // base case
        if (n == 1) return 1;      // base case
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Approach 2: Iterative (optimal)
    // Time: O(n), Space: O(1)
    public static int fibIterative(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0; // F(0)
        int prev1 = 1; // F(1)
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2; // F(i) = F(i-1) + F(i-2)
            prev2 = prev1;        // shift window
            prev1 = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.print(fibIterative(i) + " ");
        }
        // Output: 0 1 1 2 3 5 8 13 21 34 55
    }
}