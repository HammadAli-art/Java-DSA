//35
public class BinarySearchSortedArrayInsert {
    public int index(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        BinarySearchSortedArrayInsert b = new BinarySearchSortedArrayInsert();
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(b.index(arr, 6));
    }
}
