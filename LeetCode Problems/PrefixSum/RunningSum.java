/*
LeetCode 1480
Running Sum of 1d Array

This problem says that we need to create
a new array where each element is the
sum of the current element and all
previous elements.
*/

import java.util.*;

class RunningSum {
    public int[] getprefix(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }
        return ans;
    }

    public static void main(String args[]) {
        RunningSum s = new RunningSum();
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.print(Arrays.toString(s.getprefix(arr)));
    }
}