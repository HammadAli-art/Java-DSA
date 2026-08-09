class Solution {
public:

    bool Knight (vector<vector<int>>& grid, int row, int col, int n, int expec_val){
        if(row<0 || col<0 || row>=n || col>=n || grid[row][col] != expec_val){
            return false;
        }

        if(expec_val == n*n - 1){
            return true;
        }

        int ans1 = Knight (grid, row-2, col+1, n, expec_val+1);
        int ans2 = Knight (grid, row-1, col+2, n, expec_val+1);
        int ans3 = Knight (grid, row+1, col+2, n, expec_val+1);
        int ans4 = Knight (grid, row+2, col+1, n, expec_val+1);
        int ans5 = Knight (grid, row+2, col-1, n, expec_val+1);
        int ans6 = Knight (grid, row+1, col-2, n, expec_val+1);
        int ans7 = Knight (grid, row-1, col-2, n, expec_val+1);
        int ans8 = Knight (grid, row-2, col-1, n, expec_val+1);

        return ans1 || ans2 || ans3 || ans4 ||
               ans5 || ans6 || ans7 || ans8;
    }
    bool checkValidGrid(vector<vector<int>>& grid) {
        return Knight (grid, 0, 0, grid.size(), 0);

    }
};