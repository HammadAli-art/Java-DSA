class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap <Integer, Integer> m = new HashMap<>();
        int count = 0;
        for(int i:nums){
            if(m.containsKey(i)){
                int frequency = m.get(i);
                count += frequency;
                m.put(i, frequency+1);
            }else{
                m.put(i, 1);
            }
        }
        return count;
    }
}