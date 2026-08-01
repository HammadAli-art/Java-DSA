import java.util.Arrays;

class TwoSum_bruteForce {
    public int[] Sum(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        TwoSum_bruteForce f = new TwoSum_bruteForce();
        int arr[] = { 1, 2, 3, 4, 5 };
        int target = 9;
        System.out.println(Arrays.toString(f.Sum(arr, target)));
    }

}