//1295
class CountEvenDigits {
    public int findNumbers(int[] nums) {
        int evenCount = 0;
        for (int i : nums) {
            int digitCount = 0;
            if (i == 0) {
                digitCount = 1;
            } else {
                while (i != 0) {
                    i /= 10;
                    digitCount++;
                }
            }
            if (digitCount % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    public static void main(String[] args) {
        CountEvenDigits c = new CountEvenDigits();
        int arr[] = { 12, 34, 567 };
        System.out.println(c.findNumbers(arr));
    }
}