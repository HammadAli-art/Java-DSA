//219
class ContainsDuplicate_2 {
    public boolean duplicate(int nums[], int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate_2 s = new ContainsDuplicate_2();
        int arr[] = { 1, 2, 3, 1 };
        int k = 3;
        System.out.println(s.duplicate(arr, k));
    }
}