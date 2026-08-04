/*
LeetCode 27
Remove Element

This problem says that we need to remove
all occurrences of the given value from
the array. Return the number of remaining
elements after modifying the array in-place.
*/

public class RemoveElement {
    public int removeElement(int nums[], int val) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast ++;
        }
        return slow;
    }

    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        int arr[] = { 1, 1, 2, 3, 4, 5, 1 };
        int val = 1;
        System.out.println(r.removeElement(arr, val));
    }
}
