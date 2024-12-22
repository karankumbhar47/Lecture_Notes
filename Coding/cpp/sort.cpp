#include <bits/stdc++.h>
using namespace std;

class SortedStack {
public:
    stack<int> s;
    void sort();
};

void printStack(stack<int> s)
{
    while (!s.empty()) {
        printf("%d ", s.top());
        s.pop();
    }
    printf("\n");
}

int main()
{
    int t;
    cin >> t;
    while (t--) {
        SortedStack* ss = new SortedStack();
        int n;
        cin >> n;
        for (int i = 0; i < n; i++) {
            int k;
            cin >> k;
            ss->s.push(k);
        }
        ss->sort();
        printStack(ss->s);
    }
}

void SortedStack ::sort()
{
    if (!s.empty()) {
        int n = s.top();
        s.pop();
        sort();
        if (s.empty()) {
            s.push(n);
        } else {
            stack<int> temp;
            while (!s.empty() && s.top() < n) {
                temp.push(s.top());
                s.pop();
            }
            s.push(n);
            while (!temp.empty()) {
                s.push(temp.top());
                temp.pop();
            }
        }
    }
}