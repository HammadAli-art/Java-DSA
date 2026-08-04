/*
LeetCode 283
Move Zeroes

This problem says that we need to move
all zeroes to the end of the array while
keeping the relative order of the
non-zero elements the same.
*/

import java.util.Arrays;

class MoveZeroes {
    public void moveZeroes(int nums[]){
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
            }
            right ++;
        }
    }

    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        int arr[] = { 1, 0, 3, 4, 6, 3, 0, 3, 0, };
        m.moveZeroes(arr);
        System.out.print(Arrays.toString(arr));
    }
}
