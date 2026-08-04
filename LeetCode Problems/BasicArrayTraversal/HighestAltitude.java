/*
LeetCode 1732
Find the Highest Altitude

This problem says that we need to find
the highest altitude reached during the trip
using the given altitude gains.
*/

public class HighestAltitude {
    public int largestAltitude(int nums[]) {
        int currentAltitude = 0;
        int highestAltitude = 0;
        for (int i = 0; i < nums.length; i++) {
            currentAltitude += nums[i];
            if (currentAltitude > highestAltitude) {
                highestAltitude = currentAltitude;
            }
        }
        return highestAltitude;
    }

    public static void main(String[] args) {
        HighestAltitude h = new HighestAltitude();
        int arr[] = { -5, 1, 5, 0, -7 };
        System.out.println(h.largestAltitude(arr));
    }
}
