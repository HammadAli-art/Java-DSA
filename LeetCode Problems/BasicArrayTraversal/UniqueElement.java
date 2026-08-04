/*
LeetCode 136
Single Number

This problem says that every element
appears twice except one element.
We need to find that unique element.
*/

class UniqueElement {

    public int singleNumber(int nums[]) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i];
        }
        return x;
    }

    public static void main(String[] args) {
        UniqueElement e = new UniqueElement();
        int arr[] = { 2, 2, 1 };
        System.out.println(e.singleNumber(arr));
    }
}