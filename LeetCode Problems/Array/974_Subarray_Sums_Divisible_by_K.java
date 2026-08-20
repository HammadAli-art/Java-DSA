class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum[] = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            int reminder = prefixSum[i] % k;
            if (reminder < 0) {
                reminder += k;
            }
            if (map.containsKey(reminder)) {
                int frequency = map.get(reminder);
                map.put(reminder, frequency + 1);
                count += frequency;
            } else {
                map.put(reminder, 1);
            }
        }
        return count;
    }
}