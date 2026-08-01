//1920
import java.util.Arrays;

public class BuildPermutations {
    public int[] permutation(int nums[]) {
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        BuildPermutations b = new BuildPermutations();
        int arr[] = { 5, 0, 1, 2, 3, 4 };
        System.out.println(Arrays.toString(b.permutation(arr)));
    }
}
