class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int left = 0;
        List<Integer> list = new ArrayList<>();
        while (left < nums.length) {
            if (nums[left] > 0 && nums[left] <= nums.length && nums[left] != nums[nums[left] - 1]) {
                int temp = nums[left];
                nums[left] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                left++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }
}