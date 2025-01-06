#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int std[12]={0,};
    int n, k;
    int cnt = 0;
    cin >> n >> k;
    for (int i=0; i<n; i++) {
        int s, y;
        cin >> s >> y;
        std[2*(y-1)+s]++;
    }
    for (int i=0; i<12; i++) {
        if (std[i]==0)
            continue;
        else {
            cnt += (std[i] - 1)/k + 1;
        }
    }
    cout << cnt;
}