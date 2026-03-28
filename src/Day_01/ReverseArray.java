package Day_01;

/*
Problem: Reverse an Array
Topic: Arrays Basics
Day: 01

Approach:
Swap elements from start and end.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr);

        for (int x : arr) {
            System.out.print(x + " "); // Output: 5 4 3 2 1
        }

    }

    private static void reverse(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}
