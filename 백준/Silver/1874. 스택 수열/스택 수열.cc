#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    stack<int> S;
    int n;
    cin >> n;
    int cnt = 1;
    string ans;
    while (n--) {
        int t;
        cin >> t;
        while (cnt <= t) {
            S.push(cnt++);
            ans += "+\n";
        }
        if (S.top() != t) {
            cout << "NO\n"; 
            return 0;
        }
        S.pop();
        ans += "-\n";
    }
    cout << ans;
}