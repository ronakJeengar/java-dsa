package Day_01;

/*
Problem: Find Second Largest Element
Day: 01

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class FindSecondLargest {

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println("Second Largest: " + findSecondLargest(arr)); // 34
    }

    private static int findSecondLargest(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        if (arr.length < 2) {
            throw new IllegalArgumentException("Array is not eligible");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > first) {
                second = first;
                first = j;
            } else if (j > second && j != first) {
                second = j;
            }
        }
        return second;
    }
}
