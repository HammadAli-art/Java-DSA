/*
  LeetCode 1920 
  Build Array from Permutation
  This Problem Says that build a new array 
  where each element is taken from the index 
  specified by the current element.
 */

import java.util.Arrays;

public class BuildPermutations {
    public int[] permutation(int nums[]) {
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        BuildPermutations b = new BuildPermutations();
        int arr[] = { 5, 0, 1, 2, 3, 4 };
        System.out.println(Arrays.toString(b.permutation(arr)));
    }
}