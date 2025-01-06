#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    while (n--) {
        string a, b;
        cin >> a >> b;
        int i=0;
        int arr[26] = {0,};
        for (i=0; i<a.size(); i++) {
            arr[a[i]-'a']++;
        }
        for (i=0; i<b.size(); i++) {
            arr[b[i]-'a']--;
        }
        for (i=0; i<26; i++) {
            if (arr[i] != 0){
                cout << "Impossible\n";
                break;
            }
        }
        if (i==26){
            cout << "Possible\n";
        }
    }
}