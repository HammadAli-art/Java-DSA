class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int daysNeeded = 1;
            int currentWeight = 0;
            for (int i = 0; i < weights.length; i++) {
                if ((currentWeight + weights[i]) > mid) {
                    daysNeeded++;
                    currentWeight = 0;
                }
                currentWeight += weights[i];
            }
            if (daysNeeded <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}