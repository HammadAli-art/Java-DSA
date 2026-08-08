class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int max = 0;

        for (int right = left + 1; right <prices.length; right++) {
            int current =prices[right] -prices[left];
            if (current > max) {
                max = current;
            } else {
                if (prices[right] <prices[left]) {
                    left = right;
                }
            }
        }
        return max;
    }
}