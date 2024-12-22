#include <bits/stdc++.h>
#include<iostream>
#include<vector>
#include<string>
#include<bitset>
#include<cmath>
#include<numeric>
#include<limits>
#include<algorithm>

using namespace std;

class Solution{

    // Function to find the trapped water between the blocks.
    public:
    long long trappingWater(int arr[], int n){
        int left[n];
        int right[n];
        int max = INT_MIN; 
        for (int i = 0; i < n; i++)
        {
            if(max<arr[i]){
                left[i]=arr[i];
            }
            else{
                left[i] = arr[i];
            }
        }
        max = INT_MIN;
        for (int i = n-1; i >=0 ; i--)
        {
            if(max>arr[i]){
                right[i]=arr[i];
            }
            else{
                right[i] = arr[i];
            }
        }

        long long cap = 0;
        for (int i = 0; i < n; i++)
        {
            cap += min(right[i],left[i]) - arr[i];
        }

        return cap;
    }
};