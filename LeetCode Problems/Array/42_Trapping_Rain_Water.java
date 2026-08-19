class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int maxWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    int perUnit = leftMax - height[left];
                    maxWater += perUnit;
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    int perUnit = rightMax - height[right];
                    maxWater += perUnit;
                }
                right--;
            }
        }
        return maxWater;

    }
}