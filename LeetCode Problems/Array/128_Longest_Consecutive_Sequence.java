class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxLength = 1;
        int count = 1;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] == nums[left] + 1) {
                count++;
                right++;
                left++;
            } else if (nums[right] == nums[left]) {
                left++;
                right++;
            } else {
                count = 1;
                left = right;
                right++;
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
}