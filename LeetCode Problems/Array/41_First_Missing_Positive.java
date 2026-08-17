class Solution {
    public int firstMissingPositive(int[] nums) {
        int pointer = 0;
        int answer = 1;
        while (pointer < nums.length) {
            if (nums[pointer] > 0 && nums[pointer] <= nums.length && nums[pointer] != nums[nums[pointer] - 1]) {
                int temp = nums[pointer];
                nums[pointer] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                pointer++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == answer) {
                answer++;
            } else {
                return answer;
            }
        }
        return answer;
    }
}