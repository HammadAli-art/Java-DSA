import java.util.Arrays;

public class bubbleSort {
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        bubbleSort bs = new bubbleSort();
        int arr[] = { 10, 6, 9, 2, 4, 8, 7, 5, 1, 3 };
        bs.sort(arr);
    }
}
