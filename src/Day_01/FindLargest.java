package Day_01;

/*
Problem: Find Largest Element in Array
Day: 01

Time Complexity: O(n)
Space Complexity: O(1)
*/


public class FindLargest {

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 4, 6};
        System.out.println("Largest: " + findLargest(arr)); // Output: 9
    }

    private static int findLargest(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}
