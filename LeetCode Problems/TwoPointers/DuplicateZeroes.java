import java.util.Arrays;

class DuplicateZeroes {
    public void duplicate(int[] nums) {
        int countZeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeroes++;
            }
        }
        int originalIndex = nums.length - 1;
        int virtualIndex = nums.length + countZeroes - 1;
        while (originalIndex >= 0) {
            if (nums[originalIndex] != 0) {
                if (virtualIndex < nums.length) {
                    nums[virtualIndex] = nums[originalIndex];
                }
                originalIndex--;
                virtualIndex--;
            } else {
                if (virtualIndex < nums.length) {
                    nums[virtualIndex] = nums[originalIndex];
                }
                virtualIndex--;

                if (virtualIndex < nums.length) {
                    nums[virtualIndex] = nums[originalIndex];
                }
                originalIndex--;
                virtualIndex--;
            }
        }
    }

    public static void main(String[] args) {
        DuplicateZeroes d = new DuplicateZeroes();
        int arr[] = { 0 };
        d.duplicate(arr);
        System.out.println(Arrays.toString(arr));
    }
}