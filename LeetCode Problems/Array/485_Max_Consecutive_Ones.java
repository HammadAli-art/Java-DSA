class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = right + 1;
            }
        }
        if (maxLength == Integer.MIN_VALUE) {
            return 0;
        }
        return maxLength;
    }
}