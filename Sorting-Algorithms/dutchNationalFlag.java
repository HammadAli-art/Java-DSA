import java.util.Arrays;

class dutchNationalFlag {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (mid <= right) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        dutchNationalFlag dnf = new dutchNationalFlag();
        int arr[] = { 1, 0, 2, 0, 2, 1, 1, 1, 1, 0, 0, 2, 2, 2 };
        dnf.sortColors(arr);
    }
}