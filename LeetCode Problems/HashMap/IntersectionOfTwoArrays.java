//349
import java.util.*;

class IntersectionOfTwoArrays {
    public int[] Intersection(int nums1[], int nums2[]) {
        ArrayList<Integer> l = new ArrayList<>();
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            m.put(nums1[i], i);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (m.containsKey(nums2[j])) {
                l.add(nums2[j]);
                m.remove(nums2[j]);
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
        int arr2[] = { 1, 2, 2, 3 };

        System.out.println(Arrays.toString(s.Intersection(arr1, arr2)));
    }
}