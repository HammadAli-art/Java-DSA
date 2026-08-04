/*
LeetCode 26
Remove Duplicates from Sorted Array

This problem says that we need to remove
the duplicate elements from a sorted array.
Return the number of unique elements and
store them at the beginning of the array.
*/

class RemoveDuplicatesFromSorted {
    public int remove(int nums[]) {
        int slow = 0;
        int fast = 1;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSorted d = new RemoveDuplicatesFromSorted();
        int arr[] = { 1, 1, 1, 2 };
        System.out.println(d.remove(arr));
    }
}