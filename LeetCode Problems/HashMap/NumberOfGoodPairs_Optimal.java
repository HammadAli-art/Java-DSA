//1512
import java.util.HashMap;

public class NumberOfGoodPairs_Optimal {
    HashMap<Integer, Integer> m = new HashMap<>();

    public int pairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                int frequency = m.get(nums[i]);
                count += frequency;
                frequency++;
                m.put(nums[i], frequency + 1);
            } else {
                m.put(nums[i], 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfGoodPairs_Optimal n = new NumberOfGoodPairs_Optimal();
        int arr[] = { 1, 1, 2, 3 };
        System.out.println(n.pairs(arr));
    }
}
