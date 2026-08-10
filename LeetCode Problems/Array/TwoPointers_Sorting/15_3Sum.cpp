class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int first = i;
            int second = i + 1;
            int third = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (second < third) {
                List<Integer> triplets = new ArrayList<>();
                if (nums[first] + nums[second] + nums[third] == 0) {
                    triplets.add(nums[first]);
                    triplets.add(nums[second]);
                    triplets.add(nums[third]);
                    list.add(triplets);
                    second++;
                    third--;
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else if (nums[first] + nums[second] + nums[third] < 0) {
                    second++;
                } else {
                    third--;
                }
            }
        }
        return list;
    }
}