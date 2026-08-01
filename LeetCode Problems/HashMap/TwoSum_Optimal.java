//1
import java.util.HashMap;
import java.util.Arrays;

public class TwoSum_Optimal {
    public int[] Sum(int arr[], int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int second = target - current;
            if (m.containsKey(second)) {
                return new int[] { m.get(second), i };
            } else {
                m.put(current, i);
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        TwoSum_Optimal s = new TwoSum_Optimal();
        int arr[] = { 1, 2, 3, 4, 5 };
        int target = 6;
        System.out.println(Arrays.toString(s.Sum(arr, target)));
    }
}
