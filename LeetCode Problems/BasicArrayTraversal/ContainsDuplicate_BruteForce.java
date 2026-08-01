//217

class ContainsDuplicate_BruteForce {
    public boolean duplicate(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate_BruteForce s = new ContainsDuplicate_BruteForce();
        int arr[] = { 1, 6, 7, 1 };
        System.out.println(s.duplicate(arr));
    }
}