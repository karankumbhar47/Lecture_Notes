#include <iostream>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    int solve(int n, int k, vector<int> &stalls)
    {
        sort(stalls.begin(), stalls.end());
        int maxDiff = stalls[n - 1] - stalls[0];
        int low = 1;
        int ans = 0;
        int high = maxDiff;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (ifPossible(stalls, n, k,mid))
            {
                ans = mid;
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return ans;
    }

    bool ifPossible(vector<int>& stalls,int n, int k, int diff){
        int cor = stalls[0];
        int cnt = 1;
        for (int i = 0; i < n; i++)
        {
            if(stalls[i]-cor>=diff){
                cor = stalls[i];
                cnt++;
            }
            if(cnt==k){
                return true;
            }
        }
        return false;
    }

};

int main(int argc, char const *argv[])
{
    return 0;
}
