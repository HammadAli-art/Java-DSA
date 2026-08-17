class Solution {
    public int search(int[] nums, int target) {
        int slow = 0;
        int fast = nums.length - 1;

        while (slow <= fast) {
            int mid = slow + (fast - slow) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[slow] <= nums[mid]) {
                if (nums[slow] <= target && target < nums[mid]) {
                    fast = mid - 1;
                } else {
                    slow = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[fast]) {
                    slow = mid + 1;
                } else {
                    fast = mid - 1;
                }
            }
        }
        return -1;
    }
}