/*
LeetCode 724
Find Pivot Index

This problem says that we need to find
the index where the sum of all elements
on the left is equal to the sum of all
elements on the right.
*/

class PivotIndex {
    public int pivot(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int leftSum = 0;
        for (int j = 0; j < nums.length; j++) {
            int rightSum = totalSum - leftSum - nums[j];
            if (leftSum == rightSum) {
                return j;
            }
            leftSum += nums[j];
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex p = new PivotIndex();
        int arr[] = { 1, 7, 3, 6, 5, 6 };
        System.out.println(p.pivot(arr));
    }
}