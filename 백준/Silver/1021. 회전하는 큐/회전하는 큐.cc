#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    deque<int> dq;
    int n, m;
    int ans=0;
    cin >> n >> m;
    for (int i=1; i<=n; i++) {
        dq.push_back(i);
    }
    while (m--) {
        int t;
        cin >> t;
        int idx = find(dq.begin(), dq.end(), t) - dq.begin(); // idx: t가 있는 위치
        while (t != dq.front()) {
            if (idx * 2 < dq.size()) {
                dq.push_back(dq.front());
                dq.pop_front();
            } else {
                dq.push_front(dq.back());
                dq.pop_back();
            }
            ans++;
        }
        dq.pop_front();
    }
    cout << ans;
}