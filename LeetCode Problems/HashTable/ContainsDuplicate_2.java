/*
LeetCode 219
Contains Duplicate II

This problem says that we need to check
whether the same element appears again
within a distance of k indexes.
*/

import java.util.HashMap;

class ContainsDuplicate_2 {
    public boolean duplicate(int nums[], int k){
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(m.containsKey(nums[i])){
                int latestIndex = m.get(nums[i]);
                
                if(i-latestIndex <= k){
                return true;
                }
            }
                m.put(nums[i], i);
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate_2 s = new ContainsDuplicate_2();
        int arr[] = {1, 2, 3, 1};
        int k = 3;
        System.out.println(s.duplicate(arr, k));
    }
}