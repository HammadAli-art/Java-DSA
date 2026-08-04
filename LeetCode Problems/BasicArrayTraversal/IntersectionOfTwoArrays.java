/*
LeetCode 349
Intersection of Two Arrays

This problem says that we need to find
the common unique elements present
in both arrays.
*/
import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] Intersection(int nums1[], int nums2[]) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (!l.contains(nums1[i])) {
                        l.add(nums1[i]);
                        break;
                    }
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
        IntersectionOfTwoArrays s = new IntersectionOfTwoArrays();
        int arr1[] = { 1, 2, 2, 3 };
        int arr2[] = { 1, 2, 3 };

        System.out.println(Arrays.toString(s.Intersection(arr1, arr2)));
    }
}
