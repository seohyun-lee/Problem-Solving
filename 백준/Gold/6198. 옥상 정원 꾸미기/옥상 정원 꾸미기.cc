#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    stack<pair<int, long long>> S;
    vector<int> v(n+1, 0);
    for (int i=1; i<=n; i++) {
        cin >> v[i];
    }
    long long sum=0;
    for (int i=n; i>=1; i--) {
        long long cnt=0;
        while (!S.empty() && v[i] > S.top().first) {
            cnt = cnt + S.top().second + 1;
            S.pop();
        }
        sum += cnt;
        S.push({v[i], cnt});
    }
    cout << sum;
    return 0;
}