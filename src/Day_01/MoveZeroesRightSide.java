package Day_01;

/*
Problem: Move all zeros to right
Day: 01

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class MoveZeroesRightSide {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int x : nums) System.out.print(x + " "); // 1 3 12 0 0
    }

    private static void moveZeroes(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] == 0 && nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else if (nums[left] != 0) left++;
            else right--;
        }

    }
}
