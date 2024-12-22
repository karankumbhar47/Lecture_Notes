//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int prec(char c){
        switch(c){
            case '^': return 3;
            case '*': return 2;
            case '/': return 2;
            case '+': return 1;
            case '-': return 1;
            default : return -1;
        }
        return -1;
    }
    
    void inToPost(string& s,string& ans){
        stack<char> st;
        
        for(int i=0; i<s.size(); i++){
            cout<<"index "<<i<<" "<<s[i]<<" "<<ans<<endl;
            if((s[i]>='a' && s[i]<='z') || 
               (s[i]>='A' && s[i]<='Z') || 
               (s[i]>='0' && s[i]<='9')) ans+=s[i];
            else if(s[i]==')'){
                while(st.top()!='('){
                    ans+=st.top();
                    st.pop();
                }
                st.pop();
            }
            else if(s[i]=='(' || st.empty() || (!st.empty() && st.top()=='(')) st.push(s[i]);
            else{
                while(!st.empty() && st.top()!='(' && prec(s[i])>prec(st.top())){
                    ans+=st.top();
                    st.pop();
                }
                st.push(s[i]);
            }
        }
        
        while(!st.empty()){
            ans+=st.top();
            st.pop();
        }
    }
    
    string inToPre(string in_exp) {
        string ans = "";
        for(int i=0; i<in_exp.size(); i++){
            if(in_exp[i]=='(') in_exp[i]=')';
            else if(in_exp[i]==')') in_exp[i]='(';
        }

        reverse(in_exp.begin(),in_exp.end());
        cout<<in_exp<<endl;
        inToPost(in_exp,ans);
        reverse(ans.begin(),ans.end());
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t = 1;
    //cin >> t;

    // freopen ("output_gfg.txt", "w", stdout);

    while (t--) {
        // Input
        string infix = "x+(y*z/w)+u";
        //cin >> infix;

        Solution obj;
        cout << obj.inToPre(infix) << endl;

        // cout << "~\n";
    }
    // fclose(stdout);

    return 0;
}

// } Driver Code Ends