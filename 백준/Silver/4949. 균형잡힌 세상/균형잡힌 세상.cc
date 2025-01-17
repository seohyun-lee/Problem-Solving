#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    char arr[4] = {'(', ')', '[', ']'};
    string s;
    getline(cin, s);
    while (s != ".") {
        stack<int> stk;
        bool flag=true;
        for (char c : s) {
            if (c == arr[0] || c == arr[2])
                stk.push(c);
            else if (c == arr[1] || c == arr[3]) {
                int matchidx = (c == arr[1]) ? 0 : 2;
                if (!stk.empty() && stk.top() == arr[matchidx]) {
                    stk.pop();
                }
                else {
                    flag=false;
                    break;
                }
            }
        }
        if (flag && stk.empty()) cout << "yes\n";
        else cout << "no\n";
        getline(cin, s);
    }
}