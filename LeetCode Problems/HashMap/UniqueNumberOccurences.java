//1207
import java.util.*;

public class UniqueNumberOccurences {
    public boolean Occurences(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int frequency = map.get(nums[i]);
                map.put(nums[i], frequency + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        HashSet<Integer> frequencies = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (frequencies.contains(frequency)) {
                return false;
            }
            frequencies.add(frequency);
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueNumberOccurences u = new UniqueNumberOccurences();
        int arr[] = { 1, 2, 3, 2, 3, 3, 3 };
        System.out.println(u.Occurences(arr));
    }
}
