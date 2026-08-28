class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int k = 0;
        while (left < nums.length) {
            if (nums[left] != val) {
                nums[k] = nums[left];
                k++;
            }
            left++;
        }
        return k;
    }
}