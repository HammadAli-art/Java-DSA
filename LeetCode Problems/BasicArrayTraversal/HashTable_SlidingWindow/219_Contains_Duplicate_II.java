class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(m.containsKey(nums[i])){
                int previousIndex = m.get(nums[i]);
                if(i-previousIndex <= k){
                    return true;
                }
            }
            m.put(nums[i], i);
        }
        return false;
    }
}