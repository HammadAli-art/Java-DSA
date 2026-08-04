/*
LeetCode 136
Single Number

This problem says that every element
appears twice except one element.
We need to find that unique element.
*/

import java.util.HashMap;
import java.util.Map;

class UniqueElement {
    public int singleNumber(int nums[]) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                int frequency = m.get(nums[i]);
                m.put(nums[i], frequency + 1);
            } else {
                m.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getValue();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        UniqueElement e = new UniqueElement();
        int arr[] = { 1, 2, 2 };
        System.out.println(e.singleNumber(arr));
    }
}