class RemoveDuplicatesFromSorted {
    public int remove(int nums[]) {
        int slow = 0;
        int fast = 1;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSorted d = new RemoveDuplicatesFromSorted();
        int arr[] = { 1, 1, 1, 2 };
        System.out.println(d.remove(arr));
    }
}