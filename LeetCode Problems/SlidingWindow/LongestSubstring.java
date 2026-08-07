import java.util.HashMap;

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (map.containsKey(current) && map.get(current) >= left) {
                left = map.get(current) + 1;
            }
            map.put(current, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstring l = new LongestSubstring();
        String s = "abcbbaa";
        System.out.println(l.lengthOfLongestSubstring(s));
    }
}