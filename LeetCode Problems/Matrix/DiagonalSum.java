/*
LeetCode 1572
Matrix Diagonal Sum

This problem asks us to find the sum
of both the primary and secondary
diagonals of a square matrix.

If the matrix size is odd, the center
element belongs to both diagonals.
It should be counted only once.
*/

class DiagonalSum {
    public int sum(int mat[][]) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            if (i != mat.length - 1 - i) {
                sum += mat[i][mat.length - 1 - i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        DiagonalSum d = new DiagonalSum();
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(d.sum(arr));
    }
}