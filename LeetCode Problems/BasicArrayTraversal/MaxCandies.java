/*
LeetCode 1431
Kids With the Greatest Number of Candies

This problem says that we need to check
whether each kid can have the greatest
number of candies after getting the
given extra candies.
*/

import java.util.*;

class MaxCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxElement = 0;
        for (int num : candies) {
            if (num > maxElement) {
                maxElement = num;
            }
        }
        for (int num : candies) {
            if (num + extraCandies >= maxElement) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxCandies m = new MaxCandies();
        int arr[] = { 6, 2, 8, 5, 2, 1 };
        int n = 6;
        System.out.println(m.kidsWithCandies(arr, n));
    }
}