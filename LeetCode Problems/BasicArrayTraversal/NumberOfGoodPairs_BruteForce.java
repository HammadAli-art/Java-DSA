//1512
public class NumberOfGoodPairs_BruteForce {
    public int pairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfGoodPairs_BruteForce n = new NumberOfGoodPairs_BruteForce();
        int arr[] = { 1, 2, 3 };
        System.out.println(n.pairs(arr));
    }
}
