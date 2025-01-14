#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;

void parse(string& s, deque<int>& dq) {
    int cur = 0;
    for (int i=1; i+1<s.size(); i++){ // [, ] 제외
        if(s[i] == ',') {
            dq.push_back(cur);
            cur=0;
        } else {
            cur = 10*cur + (s[i]-'0');
        }
    }
    if (cur != 0)
        dq.push_back(cur);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    while (t--) {
        string p, input;
        int n;
        deque<int> dq;
        bool isReversed = 0;
        bool isErr = 0;
        
        cin >> p >> n >> input;
        if (n != 0)
            parse(input, dq);
        
        for (char c : p) {
            if (c == 'R') {
                isReversed = 1 - isReversed;
            } else if (c == 'D') {
                if (dq.empty()) {
                    cout << "error\n";
                    isErr = 1;
                    break;
                } else {
                    if (isReversed) dq.pop_back();
                    else dq.pop_front();
                    n--;
                }
            }
        }
        if (!isErr) {
            if (isReversed) reverse(dq.begin(), dq.end());
            cout << "[";
            for (int j=0; j<n; j++) {
                if (j != 0) cout << ",";
                cout << dq.front();
                dq.pop_front();
            }
            cout << "]\n";
        }
    }
}