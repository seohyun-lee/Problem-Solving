#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string s;
    cin >> s;
    bool flag = 1;
    for (int i=0; i<s.size()/2; i++) {
        if (s[i] != s[s.size()-1-i]) {
            flag = 0;
            break;
        }
    }
    cout << flag;
}