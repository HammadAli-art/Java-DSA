public class basicBinarySearch {
    public int search(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        basicBinarySearch bs = new basicBinarySearch();
        int arr[] = { 1, 2, 4, 5, 7, 8, 9, 12 };
        System.out.println(bs.search(arr, 9));
    }
}
