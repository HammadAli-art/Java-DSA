class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char current = s1.charAt(i);

            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            char current = s2.charAt(right);

            if (windowMap.containsKey(current)) {
                windowMap.put(current, windowMap.get(current) + 1);
            } else {
                windowMap.put(current, 1);
            }

            while (right - left + 1 > s1.length()) {

                char leftChar = s2.charAt(left);

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }

                left++;
            }

            if (windowMap.equals(map)) {
                return true;
            }
        }

        return false;
    }
}