/*
LeetCode 350
Intersection of Two Arrays II

This problem says that we need to find
the common elements present in both
arrays. If an element appears multiple
times, include it that many times.
*/

import java.util.*;

class IntersectionOfTwoArrays_2 {
    public int[] Intersection(int nums1[], int nums2[]) {
        ArrayList<Integer> l = new ArrayList<>();
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            if (m.containsKey(nums1[i])) {
                int frequency = m.get(nums1[i]);
                m.put(nums1[i], frequency + 1);
            } else {
                m.put(nums1[i], 1);
            }
        }
        for (int j = 0; j < nums2.length; j++) {
            if (m.containsKey(nums2[j])) {
                int frequency = m.get(nums2[j]);
                if (frequency > 0) {
                    l.add(nums2[j]);
                    m.put(nums2[j], frequency - 1);
                }
            }
        }

        int result[] = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            result[i] = l.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays_2 s = new IntersectionOfTwoArrays_2();
        int arr1[] = { 1, 2, 3 };
        int arr2[] = { 2, 2, 2 };

        System.out.println(Arrays.toString(s.Intersection(arr1, arr2)));
    }
}