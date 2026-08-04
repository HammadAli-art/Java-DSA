/*
LeetCode 1672
Richest Customer Wealth

This problem says that we need to find
the total wealth of each customer by
adding all their bank accounts and
return the maximum wealth.
*/

class MaximumWealth {
    public int maxwealth(int[][] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums[i].length; j++) {
                sum += nums[i][j];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumWealth m = new MaximumWealth();
        int arr[][] = { { 1, 2 }, { 3, 4 } };
        System.out.println(m.maxwealth(arr));

    }
}