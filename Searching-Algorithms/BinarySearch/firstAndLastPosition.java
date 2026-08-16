import java.util.Arrays;

public class firstAndLastPosition {
    public int[] indexes(int nums[], int target) {
        int answer[] = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                answer[0] = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                answer[1] = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        firstAndLastPosition fl = new firstAndLastPosition();
        int arr[] = { 1, 2, 2, 2, 2, 3 };
        System.out.println(Arrays.toString(fl.indexes(arr, 2)));
    }
}
