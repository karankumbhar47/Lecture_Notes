//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    void getAllSums(vector<int> &arr,int n,vector<int> &ans){
        if(n==arr.size()) return;

        int m = ans.size();
        for(int i=0;i<m;i++) ans.push_back(ans[i]+arr[n]);
        getAllSums(arr,n+1,ans);
        return;
    }

    vector<int> subsetSums(vector<int> arr, int n) {
        vector<int> ans = {0};
        getAllSums(arr,0,ans);
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        vector<int> arr(N);
        for (int i = 0; i < N; i++) {
            cin >> arr[i];
        }
        Solution ob;
        vector<int> ans = ob.subsetSums(arr, N);
        sort(ans.begin(), ans.end());
        for (auto sum : ans) {
            cout << sum << " ";
        }
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends