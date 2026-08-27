class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for (int right = nums.length - 1; right > 0; right--) {
            if (nums[right - 1] < nums[right]) {
                pivot = right - 1;
                break;
            }
        }
        if (pivot == -1) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            return;
        }
        int right = nums.length - 1;
        while (nums[right] <= nums[pivot]) {
            right--;
        }
        int temp = nums[right];
        nums[right] = nums[pivot];
        nums[pivot] = temp;
        pivot++;
        right = nums.length - 1;
        while (pivot < right) {
            temp = nums[pivot];
            nums[pivot] = nums[right];
            nums[right] = temp;
            pivot++;
            right--;
        }
    }
}