/*
LeetCode 744
Find Smallest Letter Greater Than Target

This problem says that we need to find
the smallest letter that is greater than
the given target. If no such letter exists,
return the first letter in the array.
*/

public class NextGreatestLetter {

    public static char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(left == letters.length){
            return letters[0];
        }
        return letters[left];
    }

    public static void main(String[] args) {

        char[] letters = {'c', 'f', 'j'};

        System.out.println(nextGreatestLetter(letters, 'a')); 
        System.out.println(nextGreatestLetter(letters, 'c')); 
        System.out.println(nextGreatestLetter(letters, 'd')); 
        System.out.println(nextGreatestLetter(letters, 'g')); 
        System.out.println(nextGreatestLetter(letters, 'j')); 
        System.out.println(nextGreatestLetter(letters, 'z')); 
    }
}