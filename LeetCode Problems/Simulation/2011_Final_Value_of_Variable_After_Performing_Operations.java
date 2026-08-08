class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String nums:operations){
            if(nums.contains("++")){
                x++;
            }else{
                x--;
            }
        }
        return x;
    }
}