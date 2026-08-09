class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxElement = 0;
        for(int num:candies){
            if(num > maxElement){
                maxElement = num;
            }
        }
        for(int num:candies){
            if(num + extraCandies >= maxElement){
                 result.add(true);
            }else{
                 result.add(false);
            }
        }
        return result;
    }
}