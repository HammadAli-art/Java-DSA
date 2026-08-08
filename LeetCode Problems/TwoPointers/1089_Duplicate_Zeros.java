class Solution {
    public void duplicateZeros(int[] arr) {
        int countZeroes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countZeroes++;
            }
        }
        int originalIndex = arr.length - 1;
        int virtualIndex = arr.length + countZeroes - 1;

        while (originalIndex >= 0) {
            if (arr[originalIndex] != 0) {
                if (virtualIndex < arr.length) {
                    arr[virtualIndex] = arr[originalIndex];
                }
                originalIndex--;
                virtualIndex--;
            } else {
                if (virtualIndex < arr.length) {
                    arr[virtualIndex] = arr[originalIndex];
                }
                virtualIndex--;
                if (virtualIndex < arr.length) {
                    arr[virtualIndex] = arr[originalIndex];
                }
                originalIndex--;
                virtualIndex--;
            }
        }
    }
}