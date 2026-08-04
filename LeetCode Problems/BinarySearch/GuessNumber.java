/*
LeetCode 374
Guess Number Higher or Lower

This problem says that we need to guess
the hidden number using the guess() API.
The API tells us whether our guess is
higher, lower, or equal to the hidden number.
*/

public class GuessNumber extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) < 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GuessNumber g = new GuessNumber();
        System.out.println(g.guessNumber(8));
    }
}