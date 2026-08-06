public class SetMatrixZero {

    public void setZero(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[] rows = new boolean[m];
        boolean[] columns = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || columns[j]) {
                    mat[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SetMatrixZero s = new SetMatrixZero();

        int[][] arr = {
                {1, 2, 3},
                {4, 3, 5},
                {0, 1, 4}
        };

        s.setZero(arr);
    }
}