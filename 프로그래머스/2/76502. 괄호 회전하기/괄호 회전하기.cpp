#include <string>
#include <stack>

using namespace std;

bool correct(char a, char b) {
    if ((a=='(' && b==')') || (a=='[' && b==']') || (a=='{' && b=='}'))
          return true;
    return false;
}

int solution(string s) {
    int answer=0;
    for (int j=0; j<s.length(); j++) {
        stack<int> stk;
        for (int i=0; i<s.length(); i++) {
            char c = s[(i+j)%s.length()];
            if (!stk.empty() && correct(stk.top(), c))
                stk.pop();
            else
                stk.push(c);
        }
        if (stk.empty())
            answer++;
    }
    return answer;
}