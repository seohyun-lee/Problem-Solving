#include <iostream>
#include <stack>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    while (n--) {
        string s;
        cin >> s;
        stack<int> stk;
        bool flag=true;
        for (char c : s) {
            if (c == '(')
                stk.push(c);
            else if (c == ')' && !stk.empty())
                stk.pop();
            else {
                flag=false;
                break;
            }
        }
        if (stk.empty() && flag==true)
            cout << "YES\n";
        else
            cout << "NO\n";
    }
}