///{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution
{
public:
    int getLeftMost(int n)
    {
        int m = 0;
        while ((1 << m) <= n)
            m++;
        return m - 1;
    }

    int countSetBits(int n)
    {
        if (n == 0)
            return 0;
        int m = getLeftMost(n);
        int upperBox = m * (1 << (m - 1));
        int rem = (n - (1 << m) + 1);
        return upperBox + rem + countSetBits(rem - 1);
    }
};

//{ Driver Code Starts.

// Driver code
int main()
{
    int t;
    cin >> t;   // input testcases
    while (t--) // while testcases exist
    {
        int n;
        cin >> n; // input n
        Solution ob;
        cout << ob.countSetBits(n) << endl; // print the answer
    }
    return 0;
}