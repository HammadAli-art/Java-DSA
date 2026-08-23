class Solution {
    public int missingNumber(int[] nums) {
        int left = 0;
        while (left < nums.length) {
            if (nums[left] < nums.length && nums[left] != nums[nums[left]]) {
                int temp = nums[left];
                nums[left] = nums[temp];
                nums[temp] = temp;
            } else {
                left++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}