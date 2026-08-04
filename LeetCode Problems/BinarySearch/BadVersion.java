/*
LeetCode 278
First Bad Version

This problem says that all versions after
the first bad version are also bad.
We need to find the first bad version
using the minimum number of API calls.
*/

public class BadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid) == true) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        BadVersion b = new BadVersion();
        System.out.println(b.firstBadVersion(8));
    }
}