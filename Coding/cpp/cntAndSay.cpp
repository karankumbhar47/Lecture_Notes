#include<iostream>
#include<string>

using namespace std;

class Solution {
public:
    string countAndSay(int n) {
        if(n==1){
            return "1";
        }
        else{
            string s = countAndSay(n-1);
            int prev = s[0];
            int cnt = 0;
            string ans = "";
            for (int i = 0; i < s.size(); i++)
            {
                if(prev==s[i]){
                    cnt++;
                }
                else{
                    ans += to_string(cnt);
                    ans += prev;
                    prev = s[i];
                    cnt = 1;
                }
            }
            ans += to_string(cnt);
            ans += prev;
            return ans;
        }
    }
};
        
    