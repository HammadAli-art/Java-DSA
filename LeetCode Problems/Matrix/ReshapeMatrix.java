/*
LeetCode 566
Reshape the Matrix

This problem asks us to reshape
the given matrix into a new
matrix with the required
number of rows and columns.

If reshaping is not possible,
return the original matrix.
*/

import java.util.Arrays;

public class ReshapeMatrix {
    public int[][] matReshape(int mat[][], int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }
        int arr[] = new int[m * n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[k] = mat[i][j];
                k++;
            }
        }
        int ans[][] = new int[r][c];
        k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = arr[k];
                k++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ReshapeMatrix obj = new ReshapeMatrix();
        int mat[][] = { { 1, 2 }, { 3, 4 } };
        System.out.println(Arrays.deepToString(obj.matReshape(mat, 2, 1)));
    }
}
