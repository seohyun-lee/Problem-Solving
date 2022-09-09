#include <iostream>
#include <string>
#include <stack>
#include <map>

using namespace std;

bool isBalanced(string &s) {
	stack<char> st;
	map<char, char> m;
	m[')'] = '(';
	m[']'] = '[';
	for (int i = 0; i < s.length(); i++) {
		switch (s[i]) {
		case '(': case '[':
			st.push(s[i]);
			break;
		case ')': case ']':
			if (st.empty() || st.top() != m[s[i]]) { //비어있거나 괄호 종류 안맞음
				return false;
			}
			st.pop(); //괄호 종류 맞음
			break;
		}
	}
	return st.empty();
}
int main() {
	string s;
	//getline(cin, <문자열 이름>): 공백 포함 입력받기
	while (getline(cin, s)) {
		if (s == ".") {
			break;
		}
		if (isBalanced(s)) {
			cout << "yes\n";
		}
		else {
			cout << "no\n";
		}
	}
	return 0;
}