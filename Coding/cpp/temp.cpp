//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int dfs(string word, string endWord, vector<int>& visited,map<string,int>& wordMap) {
        cout<<word<<" "<<endWord<<endl;
        if(word==endWord) 
            return 0;

        string all = "abcdefghijklmnopqrstuvwxyz";
        int distance = (int)1e9;

        for (int i = 0; i < word.size(); i++) {
            for (int j = 0; j < 26; j++) {
                if (all[j] != word[i]) {
                    string newWord = word;
                    newWord[i] = all[j];
                    if (wordMap.find(newWord)!=wordMap.end() && visited[wordMap[newWord]]==0) {
                        visited[wordMap[newWord]] = 1;
                        distance = min(distance, dfs(newWord,endWord,visited,wordMap)+1);
                        visited[wordMap[newWord]] = 0;
                    }
                }
            }
        }

        return distance;
    }

public:
    int ladderLength(string beginWord, string endWord,
                     vector<string>& wordList) {
        int n = wordList.size();
        map<string, int> wordMap;
        for (int i = 0; i < n; i++)
            wordMap[wordList[i]] = i;

        vector<int> visited(n, 0);
        int distance = dfs(beginWord,endWord,visited,wordMap);

        if(distance = (int)1e9)
            return 0;
        return distance;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    // cin >> tc;
    tc = 1;
    while (tc--) {
        string beginWord = "hit";
        string endWord = "cog";
        vector<string> wordList = {"hot","dot","dog","lot","log","cog"};
        Solution obj;
        int ans = obj.ladderLength(beginWord,endWord,wordList);
        cout<<ans<<endl;
    }
    return 0;
}
// } Driver Code Ends