/*
LeetCode 867
Transpose Matrix

This problem asks us to convert
the given matrix into its transpose.

In a transpose matrix, rows become
columns and columns become rows.
*/

import java.util.Arrays;

class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans[][] = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TransposeMatrix t = new TransposeMatrix();
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.deepToString(t.transpose(arr)));
    }
}