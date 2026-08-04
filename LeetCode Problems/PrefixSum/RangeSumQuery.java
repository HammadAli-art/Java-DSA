/*
LeetCode 303
Range Sum Query - Immutable

This problem says that we need to find
the sum of elements between the given
left and right indexes. Since multiple
queries are performed, we should answer
them efficiently.
*/

class RangeSumQuery{
    int prefix[];
    public RangeSumQuery(int nums[]){
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        } 
    }
    public int SumRange(int left, int right){
        if(left == 0){
            return prefix[right];
        }
        return prefix[right] - prefix[left-1];
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        RangeSumQuery r = new RangeSumQuery(nums);

        System.out.println(r.SumRange(0, 3));
        System.out.println(r.SumRange(1, 3));
        System.out.println(r.SumRange(3, 3));
        System.out.println(r.SumRange(2, 4));
    }
}