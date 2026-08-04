/*
  LeetCode 1929 
 Concatenation of Array
 This Problem Says that to Create a new array by appending 
 the original array to itself.
 */

import java.util.*;

class ConcatenationofArray {
    public int[] getconcatenation(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    public static void main(String args[]) {
        ConcatenationofArray s = new ConcatenationofArray();
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.print(Arrays.toString(s.getconcatenation(arr)));
    }
}