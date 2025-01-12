
#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string s;
    int n, m;
    
    cin >> s;
    list<char> L(s.begin(), s.end());
    list<char>::iterator t = L.end();
    
    n = s.size();
    cin >> m;
    for (int i=0; i<m; i++) {
        string cmd;
        cin >> cmd;
        if (cmd == "L"){
            if (t != L.begin())
                t--;
        } else if (cmd == "D"){
            if (t != L.end())
                t++;
        } else if (cmd == "B"){
            if (t != L.begin()) {
                t = L.erase(--t);
            }
        } else if (cmd == "P") {
            char c;
            cin >> c;
            L.insert(t, c);
        }
    }
    for (auto c : L) {
        cout << c;
    }
}