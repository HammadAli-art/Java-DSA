class Solution {
    public int trap(int[] height) {
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        int maxWater = 0;
        for (int i = 1; i < height.length; i++) {
            leftMax[0] = height[0];
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
             rightMax[height.length - 1] = height[height.length - 1];
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            int minimum = Math.min(leftMax[i], rightMax[i]);
            int perUnit = minimum - height[i];
            if (perUnit > 0) {
                maxWater += perUnit;
            }
        }
        return maxWater;
    }
}