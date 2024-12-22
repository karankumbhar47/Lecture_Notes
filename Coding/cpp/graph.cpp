#include <algorithm>
#include <bits/stdc++.h>
#include <bitset>
#include <cmath>
#include <iostream>
#include <limits>
#include <numeric>
#include <string>
#include <vector>

#define lli unsigned long long int 
#define ll long long
#define loop(i, start, end) for (lli i = start; i < end; i++)
#define rloop(i, n) for (lli i = n - 1; i >= 0; i--)
#define arrIn(arr, n) \
    loop(i, 0, n) { cin >> arr[i]; }
#define cts(k) cout << k << " ";
#define ctl(k) cout << k << endl;
#define all(vec) vec.begin(), vec.end();
#define printArr(arr, n) \
    loop(i, 0, n) { cts(arr[i]); }
#define printPair(vec)      \
    loop(i, 0, vec.size())  \
    {                       \
        cts(vec[i].first);  \
        ctl(vec[i].second); \
    }

using namespace std;

lli findSum(lli level, lli child)
{
    if (level == 0) {
        return 1;
    } else {
        lli power = pow(2, level);
        lli num = power + child - 1;
        lli diff = num - power + 1;
        lli child = (lli)ceil(diff / 2.0);
        return findSum(level - 1, child) + num;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    lli t;
    cin >> t;
    while (t--) {
        lli n;
        cin >> n;
        lli level = (lli)floor(log2(n));
        lli child = n - pow(2, level) +1;
        cout << findSum(level, child) << endl;
    }
    return 0;
}