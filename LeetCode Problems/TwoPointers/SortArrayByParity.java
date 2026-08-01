import java.util.Arrays;

class SortArrayByParity {
    public int[] sortParity(int[] nums) {
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity s = new SortArrayByParity();
        int arr[] = { 3, 2, 1, 4, 6, 7 };
        System.out.println(Arrays.toString(s.sortParity(arr)));
    }
}