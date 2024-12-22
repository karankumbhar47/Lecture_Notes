#include <bits/stdc++.h>
#include<iostream>
#include<vector>
#include<string>
#include<bitset>
#include<cmath>
#include<numeric>
#include<limits>
#include<algorithm>

#define lli long long int
#define ll long long
#define loop(i,start,end) for (lli i = start; i < end; i++)
#define rloop(i, n) for (lli i = n-1; i >= 0; i--)
#define arrIn(arr,n) loop(i,0,n){cin>>arr[i];}
#define cts(k) cout<<k<<" ";
#define ctl(k) cout<<k<<endl;
#define all(vec) vec.begin(),vec.end();
#define printArr(arr,n) loop(i,0,n){cts(arr[i]);}
#define printPair(vec) loop(i,0,vec.size()){cts(vec[i].first);ctl(vec[i].second);}
#define printVec(vec) loop(i,0,vec.size()){cts(vec[i]);}

using  namespace std;
//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

//Position this line where user code will be pasted.
class Node {
public:
    int data,key;
    Node* next;
    Node* prev;
    Node(int data, int key) {
        this->data = data;
        this->key  = key;
        this->next = nullptr;
        this->prev = nullptr;
    }
};

class LRUCache {
public:
    unordered_map<int, Node*> mp;
    Node *head; 
    Node *tail;
    int c;

    LRUCache(int capacity) {
        this->c = capacity;
        this->head = new Node(-1,-1);
        this->tail = new Node(-1,-1);
        this->head->next = tail;
        this->tail->prev = head;
    }

    int get(int key) {
        if (mp.find(key) == mp.end())
            return -1;

        Node* node = mp[key];
        if (head->next != node) {
            this->eraseNode(node);
            this->insertAtHead(node);
        }
        return node->data;
    }

    void put(int key, int value) {
        if (mp.find(key) == mp.end()) {
            if (mp.size() >= c && c>=1) {
                mp.erase(tail->prev->key);
                this->eraseNode(tail->prev);
            }
            
            Node* node = new Node(value,key);
            this->insertAtHead(node);
            mp[key] = node;
        }
        else{
            Node* node = mp[key];

            this->eraseNode(node);
            this->insertAtHead(node);

            node->data = value;
        }
    }

    void insertAtHead(Node* node) {
        Node* next = head->next;

        head->next = node;
        node->prev = head;

        node->next = next;
        next->prev = node;
    }

    void eraseNode(Node* node){
        Node* next = node->next;
        Node* prev = node->prev;

        prev->next = next;
        next->prev = prev;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */

//{ Driver Code Starts.
//Back-end complete function template in C++

int main() {
    int t;
    //cin >> t;
    //cin.ignore();
    t = 1;
    while (t--) {
        LRUCache ob = LRUCache(2);
        ob.put(1,1);
        ob.put(2,2);
        ctl(ob.get(3));
        ob.put(3,3);
        ctl(ob.get(2));
        ob.put(4,4);
        ctl(ob.get(1));
        ctl(ob.get(3));
        ctl(ob.get(4));
    }
}
// } Driver Code Ends