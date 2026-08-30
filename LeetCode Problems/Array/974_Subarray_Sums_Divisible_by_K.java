class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int reminder = sum % k;
            if (reminder < 0) {
                reminder += k;
            }
            if (map.containsKey(reminder)) {
                count += map.get(reminder);
                map.put(reminder, map.get(reminder) + 1);
            } else {
                map.put(reminder, 1);
            }
        }
        return count;
    }
}