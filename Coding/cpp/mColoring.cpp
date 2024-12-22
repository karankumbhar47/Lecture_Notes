//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

void printArr(int arr[],int n){
    for(int i=0; i<n; i++) cout<<arr[i]<<" ";
    cout<<endl;
}

// } Driver Code Ends
class Solution {
public:
    bool isValid(int c,int vertex,int n,int color[],bool graph[101][101]){
        for(int i=0; i<n; i++){
            cout<<vertex<<" "<<i<<" "<<graph[vertex][i]<<endl;
            if(graph[vertex][i] && color[i]==c) return false; 
        }
        cout<<vertex<<" "<<c<<"valid"<<endl;
        return true;
    }

    bool helper(bool graph[101][101], int m, int n, int vertex, int color[]){
        if (vertex == n)
            return true;

        for(int i=0; i<m; i++){
            cout<<i<<" "<<vertex<<endl;
            if(isValid(i,vertex,n,color,graph)==true){
                color[vertex] = i;
                if(helper(graph,m,n,vertex+1,color)) return true;
                color[vertex] = -1;
            }
        }
        return false;
    }

    bool graphColoring(bool graph[101][101], int m, int n)
    {
        int color[n];
        for(int i=0 ; i<n; i++) color[i]=-1;
        return helper(graph, m, n, 0, color)==true;
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--) {
        int n, m, e;
        cin >> n >> m >> e;
        int i;
        bool graph[101][101];
        for (i = 0; i < n; i++) {
            memset(graph[i], 0, sizeof(graph[i]));
        }
        for (i = 0; i < e; i++) {
            int a, b;
            cin >> a >> b;
            graph[a - 1][b - 1] = 1;
            graph[b - 1][a - 1] = 1;
        }
        Solution ob;
        cout << ob.graphColoring(graph, m, n) << endl;
    }
    return 0;
}

// } Driver Code Ends