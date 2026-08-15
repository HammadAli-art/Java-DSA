class Solution {
    public int maxArea(int[] height) {
        int maxWaterArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            int distance = Math.min(height[left], height[right]);
            int currentArea = distance * width;
            maxWaterArea = Math.max(currentArea, maxWaterArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWaterArea;
    }
}