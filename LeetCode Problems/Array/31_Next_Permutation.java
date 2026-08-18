class Solution {
    public void nextPermutation(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int pivot = -1;
        while (right > left) {
            if (nums[right - 1] < nums[right]) {
                pivot = right - 1;
                break;
            } else {
                right--;
            }
        }
        if (pivot == -1) {
            left = 0;
            right = nums.length - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            return;
        }
        right = nums.length - 1;
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