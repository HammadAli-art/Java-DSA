/*
LeetCode 217
Contains Duplicate

This problem says that we need to check
whether the array contains any duplicate
element. If a duplicate exists, return
true; otherwise, return false.
*/

import java.util.HashMap;

class ContainsDuplicate_Optimal {
    public boolean duplicate(int nums[]){
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(m.containsKey(nums[i])){
                return true;
            }else{
                m.put(nums[i], i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate_Optimal s = new ContainsDuplicate_Optimal();
        int arr[] = {1, 6, 7};
        System.out.println(s.duplicate(arr));
    }
}