//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function template for C++

class Solution {
public:
    void getPath(int i, int j, int n, string curr, vector<vector<int>>& mat, vector<string>& ans)
    {
        cout << i << " " << j << endl;
        if (i < 0 || i >= n || j >= n || j < 0)
            return;
        if (mat[i][j] == 0 || mat[i][j] == -1)
            return;
        if (i == n - 1 && j == n - 1)
            ans.push_back(curr);
        mat[i][j] = -1;
        getPath(i - 1, j, n, curr + "U", mat, ans);
        getPath(i, j - 1, n, curr + "L", mat, ans);
        getPath(i + 1, j, n, curr + "D", mat, ans);
        getPath(i, j + 1, n, curr + "R", mat, ans);
        mat[i][j] = 1;
    }

    vector<string> findPath(vector<vector<int>>& mat)
    {
        vector<string> ans;
        getPath(0, 0, mat.size(), "", mat, ans);
        return ans;
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int>> m(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> m[i][j];
            }
        }
        Solution obj;
        vector<string> result = obj.findPath(m);
        sort(result.begin(), result.end());
        if (result.size() == 0)
            cout << -1;
        else
            for (int i = 0; i < result.size(); i++)
                cout << result[i] << " ";
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends