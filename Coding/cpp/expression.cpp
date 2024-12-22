#include <bits/stdc++.h>
#include<iostream>
#include<vector>
#include<string>
#include<bitset>
#include<cmath>
#include<numeric>
#include<limits>
#include<algorithm>

//#define lli long long int
#define lli long
#define ll long long
#define loop(i,start,end) for (lli i = start; i < end; i++)
#define rloop(i, n) for (lli i = n-1; i >= 0; i--)
#define arrIn(arr,n) loop(i,0,n){cin>>arr[i];}
#define cts(k) cout<<k<<" ";
#define ctl(k) cout<<k<<endl;
#define all(vec) vec.begin(),vec.end();
#define printArr(arr,n) loop(i,0,n){cts(arr[i]);}
#define printPair(vec) loop(i,0,vec.size()){cts(vec[i].first);ctl(vec[i].second);}

using  namespace std;

class Solution {
public:
    void findAns(string& numStr, int target, int i, lli eval, lli prev,
                 string path, vector<string>& ans) {
        // cout<<i<<" "<<eval<<" "<<path<<endl;
        
        // cout<<numStr.size()<<endl;
        if (i == numStr.size()) {
            if (eval == target){
                cout<<"push "<<path<<endl;
                ans.push_back(path);
            }
            cout<<"return from "<<i<<" with path "<<path<<endl;
            return;
        }

        string temp = "";
        lli number = 0;
        for (int j = i; j < numStr.size(); j++) {
            if (j > i && numStr[i] == '0'){
                cout<<"if"<<endl;
                return;
            }
            temp += numStr[j];
            number = number * 10 + (numStr[j] - '0');
            cout<<"number "<<number<<endl;

            if (i == 0) {
                findAns(numStr, target, i + 1, eval + number, number,
                       path + temp, ans);
            } else {
                findAns(numStr, target, i + 1, eval + number, number,
                        path+ "+" + temp, ans);
                findAns(numStr, target, i + 1, eval - number, -number,
                        path+ "-" + temp, ans);
                if(prev>INT_MAX || prev<INT_MIN || number>INT_MAX || number<INT_MIN) return;
                findAns(numStr, target, i + 1, eval - prev + (prev * number),
                        prev * number, path+ "*" + temp, ans);
            }
        }
        return;
    }

    vector<string> addOperators(string num, int target) {
        vector<string> ans;
        findAns(num,target,0,0,0,"",ans);
        return ans;
    }
};


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    lli t;
    cin>>t;
    while(t--){
        string s;
        cin>>s;
        int target; 
        cin>>target;
        Solution sol;
        vector<string> vec = sol.addOperators(s,target);
        for(int i=0; i<s.size(); i++) cout<<vec[i]<<" ";
        cout<<endl;
    }
    return 0;
}


