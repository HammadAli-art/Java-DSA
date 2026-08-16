public class linearSearch {
    public int search(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        linearSearch ls = new linearSearch();
        int arr[] = { 4, 5, 6, 2, 9, 10, 1, 11, 20 };
        System.out.println(ls.search(arr, 10));
    }
}
