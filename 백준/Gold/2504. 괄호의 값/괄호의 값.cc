#include <iostream>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string str;
    cin >> str;

    stack<char> S;
    int tmp = 1, val = 0;
    bool flag = false;

    for (size_t i = 0; i < str.size(); i++) {
        char c = str[i];
        if (c == '(') {
            tmp *= 2;
            S.push(c);
        } else if (c == '[') {
            tmp *= 3;
            S.push(c);
        } else if (c == ')') {
            if (S.empty() || S.top() != '(') {
                flag = true;
                break;
            }
            if (str[i - 1] == '(') val += tmp;
            tmp /= 2;
            S.pop();
        } else if (c == ']') {
            if (S.empty() || S.top() != '[') {
                flag = true;
                break;
            }
            if (str[i - 1] == '[') val += tmp;
            tmp /= 3;
            S.pop();
        } else {
            flag = true;
            break;
        }
    }

    if (flag || !S.empty()) {
        cout << 0;
    } else {
        cout << val;
    }

    return 0;
}
