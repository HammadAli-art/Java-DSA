/*
LeetCode 1207
Unique Number of Occurrences

This problem says that we need to check
whether the frequency of every element
in the array is unique. If any two
elements have the same frequency,
return false.
*/

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
