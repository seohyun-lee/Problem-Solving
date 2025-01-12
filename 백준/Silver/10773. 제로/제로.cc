
#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int k;
    long long sum = 0;
    cin >> k;
    stack<int> S;
    for (int i=0; i<k; i++) {
        int a;
        cin >> a;
        if (a == 0) {
            S.pop();
        } else {
            S.push(a);
        }
    }
    while (!S.empty()) {
        sum += S.top();
        S.pop();
    }
    cout << sum;
}