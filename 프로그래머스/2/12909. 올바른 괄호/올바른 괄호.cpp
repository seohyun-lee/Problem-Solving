#include <string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    stack<int> stk;
    for(int i=0; i<s.length(); i++) {
        if (s[i]=='(') stk.push(s[i]);
        else {
            if (stk.top() == '(')
                stk.pop();
            else
                return false;
        }
    }
    if (stk.empty())
        return true;
    return false;
}