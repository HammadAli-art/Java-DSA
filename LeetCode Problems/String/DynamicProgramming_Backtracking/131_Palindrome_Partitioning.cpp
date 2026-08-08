class Solution {
public:

bool is_palindrome(string s){
       int left = 0;
       int right = s.size() - 1;

       while(left < right){
            if(s[left] != s[right]){
                return false;
            }
            left++;
            right--;
       }
       return true;
}

void get_all_parts(string s, vector<string>& partitions, vector<vector<string>>& ans){
         if(s.size() == 0){
            ans.push_back(partitions);
            return;
         }

         for(int i = 0; i < s.size(); i++){
            string part = s.substr(0, i + 1);
            if(is_palindrome(part)){
                partitions.push_back(part);
                get_all_parts(s.substr(i + 1), partitions, ans);
                partitions.pop_back();
            }
         }
}

vector<vector<string>> partition(string s) {
        vector<string> partitions;
        vector<vector<string>> ans;
        get_all_parts(s, partitions, ans);
        return ans;
}
};
