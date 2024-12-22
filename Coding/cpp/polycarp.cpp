#include <bits/stdc++.h>
#include <iostream>
#include <vector>
#include <string>
#include <bitset>
#include <cmath>
#include <numeric>
#include <limits>
#include <algorithm>

#define lli long long int
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

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    lli t;
    cin >> t;
    while (t--)
    {
        lli n;
        cin >> n;
        lli arr[n];
        arrIn(arr, n);
        lli maxScore = 0;
        for (int j = 0; j < n; j++)
        {
            lli score = 0;
            int i = j;
            while (i < n)
            {
                score += arr[i];
                i = i + arr[i];
                if (i >= n && maxScore < score)
                {
                    maxScore = score;
                    break;
                }
            }
        }
        cout << maxScore << endl;
    }
    return 0;
}