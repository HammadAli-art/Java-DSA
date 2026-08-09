class Solution {
public:
set<vector<int>> s;
    void get_all_combinations(vector<int>& candidates, int tar, int idx, vector<int>& combin, vector<vector<int>>& ans){

        if(idx == candidates.size() || tar<0){
            return;
        }
        if(tar == 0){
           if(s.find(combin) == s.end()){
           ans.push_back({combin});
           s.insert(combin);
           }
            return;
        }

        combin.push_back(candidates[idx]);
        // Single Inclusion
        get_all_combinations(candidates, tar-candidates[idx], idx+1, combin, ans);
        // Multiple Incusions
        get_all_combinations(candidates, tar-candidates[idx], idx, combin, ans);
        // Exclusion
        combin.pop_back();
        get_all_combinations(candidates, tar, idx+1, combin, ans);
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> combin;
        get_all_combinations(candidates, target, 0, combin, ans);
        return ans;
    }
};