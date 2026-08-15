class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        int subtraction = 0;
        while (n > 0) {
            int digit = n % 10;
            product = product * digit;
            sum = sum + digit;
            n /= 10;
            subtraction = product - sum;
        }
        return subtraction;
    }
}