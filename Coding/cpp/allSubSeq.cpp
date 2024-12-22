#include <bits/stdc++.h>
using namespace std;

void printVec(vector<string> vec);

class Solution {
public:
    int helper(string s,int arr[26])
    {
        if (s.empty()) {
            return 1;
        } else {
            int prev = helper(s.substr(0, s.size() - 1),arr);
            int ans;
            for (int i = 0; i < prev.size(); i++) {
                ans.push_back(prev[i] + s.back());
                if (prev[i].back() != s.back())
                    ans.push_back(prev[i]);
            }
            return ans;
        }
    }

    string betterString(string str1, string str2)
    {
        printVec(helper(str1));
        printVec(helper(str2));
        if (helper(str1).size() >= helper(str2).size())
            return str1;
        return str2;
    }
};

void printVec(vector<string> vec){
    for(string s: vec){
        cout<<s<<" ";
    }
    cout<<endl;
}

int main()
{
    int t;
    cin >> t;
    while (t--) {
        string str1, str2;
        cin >> str1 >> str2;
        Solution obj;
        string ans = obj.betterString(str1, str2);
        cout << ans << "\n";
    }
}
