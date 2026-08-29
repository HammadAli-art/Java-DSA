class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        if (maxLength == Integer.MIN_VALUE) {
            return 0;
        }
        return maxLength;
    }
}