class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (right < k) {
                sum += nums[right];
            } else {
                sum = sum - nums[left] + nums[right];
                left++;
            }
            if (right >= k - 1) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return (double) maxSum / k;
    }
}