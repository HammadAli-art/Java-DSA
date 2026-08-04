/*
LeetCode 1470
Shuffle the Array

This problem says that the array is divided
into two equal parts. We need to rearrange
the elements by taking one element from
each part alternately.
*/

import java.util.Arrays;

class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[nums.length];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }

    public static void main(String[] args) {
        ShuffleArray s = new ShuffleArray();
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int n = 3;
        System.out.println(Arrays.toString(s.shuffle(arr, n)));
    }
}