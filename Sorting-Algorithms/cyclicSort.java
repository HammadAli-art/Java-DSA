public class cyclicSort {
    public void sort(int nums[]) {
        int left = 0;
        int answer = 1;
        while (left < nums.length) {
            if (nums[left] > 0 && nums[left] <= nums.length && nums[left] != nums[nums[left] - 1]) {
                int temp = nums[left];
                nums[left] = nums[temp - 1];
                nums[temp - 1] = temp;

            } else {
                left++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == answer) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        cyclicSort cs = new cyclicSort();
        int arr[] = { 3, 2, 1, 10, 9, 4, 5, 6, 8 };
        cs.sort(arr);
    }
}
