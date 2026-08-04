/*
LeetCode 977
Squares of a Sorted Array

This problem says that we need to square
each element of the sorted array and
return the squares in sorted order.
*/

import java.util.*;

class SquareofSortedArray {
    public int[] square(int nums[]) {
        int result[] = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index] = nums[left] * nums[left];
                left++;
                index--;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
                index--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SquareofSortedArray s = new SquareofSortedArray();
        int arr[] = { -5, 1, 2, 3, 4 };
        System.out.print(Arrays.toString(s.square(arr)));
    }
}
