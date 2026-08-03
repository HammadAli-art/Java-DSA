//238
import java.util.Arrays;

class ProductOfArrayExceptItSelf {
    public int[] productArray(int nums[]) {
        int answer[] = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int suffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptItSelf p = new ProductOfArrayExceptItSelf();
        int arr[] = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(p.productArray(arr)));
    }
}
