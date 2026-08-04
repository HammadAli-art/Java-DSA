/*
LeetCode 704
Binary Search

This problem says that we need to find
the index of the target element in a
sorted array using Binary Search.
If the target is not found, return -1.
*/

public class BinarySearchSortedArray {
    public int index(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchSortedArray b = new BinarySearchSortedArray();
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(b.index(arr, 4));
    }
}
