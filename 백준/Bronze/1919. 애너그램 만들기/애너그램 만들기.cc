
#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string sa, sb;
    int x[26] = {0,};
    int y[26] = {0,};
    int cnt = 0;
    
    cin >> sa >> sb;
    for (int i=0; i<sa.size(); i++) {
        x[sa[i]-'a']++;
    }
    for (int i=0; i<sb.size(); i++) {
        y[sb[i]-'a']++;
    }
    for (int i=0; i<26; i++) {
        cnt += abs(x[i]-y[i]);
    }
    cout << cnt;
    return 0;
}