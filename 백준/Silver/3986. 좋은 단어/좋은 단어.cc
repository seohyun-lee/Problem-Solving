#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n, cnt=0;
    cin >> n;
    while (n--) {
        string s;
        cin >> s;
        stack<int> stk;
        bool flag=true;
        for (char c : s) {
            if (stk.empty() || stk.top() != c)
                stk.push(c);
            else
                stk.pop();
        }
        if (stk.empty()) cnt++;
    }
    cout << cnt;
}