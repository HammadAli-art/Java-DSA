class Solution {
public:
    void printsubsets(vector<int>& nums, vector<int>& ans, int i, vector<vector<int>>& allsubsets){

        if(i == nums.size()){
            allsubsets.push_back({ans});
            for(int val: ans){
                cout<<val<<" ";
            }
            cout<<endl;
            return;
        }

        ans.push_back(nums[i]);
        printsubsets(nums, ans, i+1, allsubsets);

        ans.pop_back();
        printsubsets(nums, ans, i+1, allsubsets);
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> allsubsets;
        vector<int> ans;
        printsubsets(nums, ans, 0, allsubsets);
        return allsubsets;
    }
};