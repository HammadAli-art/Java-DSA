class MaximumConsecutiveOnes {
    public int findMax(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    public static void main(String[] args) {
        MaximumConsecutiveOnes m = new MaximumConsecutiveOnes();
        int arr[] = { 1, 1, 1, 0, 0, 1, 1, 1, 1 };
        System.out.println(m.findMax(arr));
    }
}