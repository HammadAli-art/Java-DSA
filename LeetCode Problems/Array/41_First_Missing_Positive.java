class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int answer = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                set.add(nums[i]);
            }
            while (set.contains(answer)) {
                answer++;
            }
        }
        return answer;
    }
}