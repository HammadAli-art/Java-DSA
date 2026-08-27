class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int first = i;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                int second = j;
                int third = j + 1;
                int fourth = nums.length - 1;
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (third < fourth) {
                    List<Integer> quadruplets = new ArrayList<>();
                    long sum = (long) nums[i] + nums[j] + nums[third] + nums[fourth];
                    if (sum == target) {
                        quadruplets.add(nums[first]);
                        quadruplets.add(nums[second]);
                        quadruplets.add(nums[third]);
                        quadruplets.add(nums[fourth]);
                        result.add(quadruplets);
                        third++;
                        fourth--;

                        while (third < fourth && nums[third] == nums[third - 1]) {
                            third++;
                        }
                        while (third < fourth && nums[fourth] == nums[fourth + 1]) {
                            fourth--;
                        }
                    } else if (sum < target) {
                        third++;
                    } else {
                        fourth--;
                    }
                }
            }
        }
        return result;
    }
}
