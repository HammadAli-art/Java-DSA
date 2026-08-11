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
    int index = i+1;
    while(index<nums.size() && nums[index] == nums[i]) index++;
        printsubsets(nums, ans, index, allsubsets);
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> allsubsets;
        vector<int> ans;
        printsubsets(nums, ans, 0, allsubsets);
        return allsubsets;
    }
};