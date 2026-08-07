class MinimumSubarrayLength {
    public int minLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }

    public static void main(String[] args) {
        MinimumSubarrayLength m = new MinimumSubarrayLength();
        int arr[] = { 2, 3, 4, 5, 7, 8 };
        System.err.println(m.minLen(15, arr));
    }
}