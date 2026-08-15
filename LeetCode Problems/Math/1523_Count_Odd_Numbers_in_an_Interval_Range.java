class Solution {
    public int countOdds(int low, int high) {
        int oddTillHigh = (high + 1) / 2;
        int oddBeforeLow = low / 2;
        int oddRange = oddTillHigh - oddBeforeLow;
        return oddRange;
    }
}