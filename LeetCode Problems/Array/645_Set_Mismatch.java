class Solution {
    public int[] findErrorNums(int[] nums) {
        int left = 0;
        int missing = 1;
        int duplicate = -1;
        while (left < nums.length) {
            if (nums[left] <= nums.length && nums[left] > 0 && nums[left] != nums[nums[left] - 1]) {
                int temp = nums[left];
                nums[left] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                left++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                duplicate = nums[i];
                missing = i + 1;
            }
        }
        return new int[] { duplicate, missing };
    }
}