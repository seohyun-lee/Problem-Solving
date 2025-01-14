#include <iostream>
#include <queue>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    queue<int> Q;
    for (int i=0; i<n; i++) {
        string s;
        cin >> s;
        if (s == "push") {
            int x;
            cin >> x;
            Q.push(x);
        } else if (s == "pop") {
            if (Q.empty()) cout << "-1" << "\n";
            else {
                cout << Q.front() << "\n";
                Q.pop();
            }
        } else if (s == "size") {
            cout << Q.size() << "\n";
        } else if (s == "front") {
            if (Q.empty()) cout << "-1" << "\n";
            else cout << Q.front() << "\n";
        } else if (s == "back") {
            if (Q.empty()) cout << "-1" << "\n";
            else cout << Q.back() << "\n";
        } else if (s == "empty") {
            cout << Q.empty() << "\n";
        }
    }
}