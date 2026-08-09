class Solution{
    public int[] twoSum(int nums[], int target){
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int k=0; k<nums.length; k++){
            int current = nums[k];
            int second = target - current;
            if(m.containsKey(second)){
                return new int[]{m.get(second), k};
            }else{
                m.put(current, k);
            }
        }
        return new int[]{-1, -1};
    }
}