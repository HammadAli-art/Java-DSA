class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean present[] = new boolean[nums.length + 1];
        int answer = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length)
                present[nums[i]] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (present[answer] == true) {
                answer++;
            } else {
                return answer;
            }
        }
        return answer;
    }
}