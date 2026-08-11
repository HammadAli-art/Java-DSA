class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i:nums){
           if(m.containsKey(i)){
            return true;
           }else{
            m.put(i, 0);
           }
        }
        return false;
    }
}