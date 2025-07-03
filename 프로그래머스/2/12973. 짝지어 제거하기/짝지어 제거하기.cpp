#include <iostream>
#include <stack>
using namespace std;

int solution(string s)
{
    stack<char> stk;
    int answer=0;
    for (int i=0; i<s.length(); i++) {
        if (i==0 || stk.empty() || stk.top()!=s[i])
            stk.push(s[i]);
        else
            stk.pop();
    }
    if (!stk.empty())
        return 0;
    return 1;
}