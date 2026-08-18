class Solution{
    public int[] twoSum(int nums[], int target){
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int current = nums[i];
            int second = target - current;
            if(m.containsKey(second)){
                return new int[]{m.get(second), i};
            }else{
                m.put(current, i);
            }
        }
        return new int[]{-1, -1};
    }
}