/*
LeetCode 167
Two Sum II - Input Array Is Sorted

This problem says that we need to find
the two numbers in the sorted array
whose sum is equal to the given target
and return their 1-based indexes, but in this problem
index will start from one not from 0.
*/

import java.util.Arrays;

class TwoSum_2 {
    public int[] sum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[] { left+1, right+1 };
            }else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
         return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        TwoSum_2 s = new TwoSum_2();
        int arr[] = { 1, 2, 3, 4, 5 };
        int t = 9;
        System.out.println(Arrays.toString(s.sum(arr, t)));
    }
}