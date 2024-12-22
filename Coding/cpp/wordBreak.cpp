#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    bool findword(string s, vector<string>& dict) {
        if(s.empty()) return true;

        cout<<s<<endl;
        for(int i=1;i<s.size()+1;i++){
            cout<<s.substr(i)<<endl;
            if(find(dict.begin(),dict.end(),s.substr(0,i))!=dict.end()){
                if(findword(s.substr(i),dict)) return true;
                else{
                    cout<<"not found "<<s.substr(i)<<endl;;
                }
            }
            else{
                cout<<"dict not found "<<s.substr(0,i)<<endl;
            }
        } 
        return false;
    }

    bool wordBreak(string s, vector<string>& worddict) {
        return findword(s, worddict);
    }
};

int main(){
    int t;
    cin>>t;
    while(t--){
        vector<string> dict;
        dict.push_back("cats");
        dict.push_back("dog");
        dict.push_back("sand");
        dict.push_back("and");
        dict.push_back("cat");
        Solution s;
        cout<<s.wordBreak("catsandog",dict);
    }
    return 0;
}