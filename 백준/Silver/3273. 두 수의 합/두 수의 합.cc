#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n, x;
    int cnt=0;
    int num[100001] = {0,};
    int freq[2000001] = {0,};
    
    cin >> n;
    for (int i=0; i<n; i++){
        cin >> num[i];
    }
    cin >> x;
    
    for (int i=0; i<n; i++){
        if (x - num[i] > 0 && freq[x-num[i]]) {
            cnt++;
        }
        freq[num[i]]=1;
    }
    cout << cnt;
}