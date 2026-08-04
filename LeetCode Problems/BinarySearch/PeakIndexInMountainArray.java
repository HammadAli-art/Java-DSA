/*
LeetCode 852
Peak Index in a Mountain Array

This problem says that we need to find
the index of the peak element in a
mountain array. A mountain array first
increases and then decreases.
*/

public class PeakIndexInMountainArray {
    public int index(int nums[]) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray p = new PeakIndexInMountainArray();
        int arr[] = { 0, 1, 0 };
        System.out.println(p.index(arr));
    }
}
