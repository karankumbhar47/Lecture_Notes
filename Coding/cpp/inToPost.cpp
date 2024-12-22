//{ Driver Code Starts
// C++ implementation to convert infix expression to postfix
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // Function to convert an infix expression to a postfix expression.
    string infixToPostfix(string s) {
        map<char,int> mp= {
            {'^',3}, {'*',2},{'/',2}, {'+',1}, {'-',1}, {'(',0},{')',0}
        };
        stack<char> st;
        string ans ="";
        for(int i=0; i<s.size(); i++){
            cout<<i<<endl;
            if(mp.find(s[i])!=mp.end()){
                if(s[i]==')'){
                    while(!st.empty() && st.top()!='('){
                        ans+= st.top();
                        st.pop();
                    }
                    st.pop();
                }
                else if(st.empty() || st.top() == '(') st.push(s[i]);
                else if(mp[s[i]] !=0 && mp[st.top()]-mp[s[i]]>=0){
                    cout<<s[i]<<' '<<st.top()<<endl;
                    while(!st.empty() && st.top()!='(' && (mp[st.top()]-mp[s[i]])>=0){
                        ans+=st.top();
                        st.pop();
                    }
                    st.push(s[i]);
                }
                else st.push(s[i]);
            }
            else ans+=s[i];
            cout<<ans<<endl;
        }
        
        while(!st.empty()) {
            ans+=st.top();
            st.pop();
        }
        return ans;
    }

};


//{ Driver Code Starts.
// Driver program to test above functions
int main() {
    int t;
    cin >> t;
    cin.ignore(INT_MAX, '\n');
    while (t--) {
        string exp;
        cin >> exp;
        Solution ob;
        cout << ob.infixToPostfix(exp) << endl;
    }
    return 0;
}

// } Driver Code Ends