package Day_02;

/*
Day: 02
Topic: Java Methods & Recursion Basics

Concepts Covered:
1. Basic methods
2. Method overloading
3. Array reference swapping
4. Recursion (Factorial)
5. Recursive array sum
6. Fast input using BufferedReader

Time Complexity:
- printArray → O(n)
- findMax → O(n)
- factorial → O(n)
- arraySum → O(n)
*/

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day2_Methods {

    // ─────────────────────────────────────────
    // 1. BASIC METHOD — No return value
    // ─────────────────────────────────────────
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ─────────────────────────────────────────
    // 2. METHOD WITH RETURN VALUE
    // ─────────────────────────────────────────
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    // ─────────────────────────────────────────
    // 3. METHOD OVERLOADING
    //    Same name, different parameters
    // ─────────────────────────────────────────
    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // ─────────────────────────────────────────
    // 4. SWAP USING ARRAY (pass by reference)
    // ─────────────────────────────────────────
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        // Changes WILL reflect outside — array is reference
    }

    // ─────────────────────────────────────────
    // 5. RECURSION — First Look
    //    Factorial: n! = n × (n-1) × ... × 1
    // ─────────────────────────────────────────
    public static long factorial(int n) {
        // BASE CASE — recursion must always have one!
        if (n == 0 || n == 1) {
            return 1;
        }
        // RECURSIVE CASE
        return n * factorial(n - 1);
    }

    // ─────────────────────────────────────────
    // 6. RECURSION — Sum of array
    // ─────────────────────────────────────────
    public static int arraySum(int[] arr, int index) {
        // Base case: passed the last index
        if (index == arr.length) {
            return 0;
        }
        // Current element + sum of remaining
        return arr[index] + arraySum(arr, index + 1);
    }

    // ─────────────────────────────────────────
    // 7. FAST INPUT using BufferedReader
    //    Use this for competitive programming!
    // ─────────────────────────────────────────
    public static void fastInputDemo() throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // read n
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        printArray(arr);
    }

    // ─────────────────────────────────────────
    // MAIN METHOD
    // ─────────────────────────────────────────
    public static void main(String[] args) {

        // Test printArray
        int[] arr = {5, 3, 8, 1, 9, 2};
        System.out.print("Array: ");
        printArray(arr);

        // Test findMax
        System.out.println("Max: " + findMax(arr));

        // Test overloading
        System.out.println("add(2,3) = " + add(2, 3));
        System.out.println("add(2.5,3.5) = " + add(2.5, 3.5));
        System.out.println("add(1,2,3) = " + add(1, 2, 3));

        // Test swap
        System.out.print("Before swap: ");
        printArray(arr);
        swap(arr, 0, 5);
        System.out.print("After swap(0,5): ");
        printArray(arr);

        // Test recursion — factorial
        System.out.println("5! = " + factorial(5));
        System.out.println("10! = " + factorial(10));

        // Test recursive array sum
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Recursive sum: " + arraySum(nums, 0));

        // Scanner input demo
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        // int x = sc.nextInt(); // uncomment when running locally
    }
}
