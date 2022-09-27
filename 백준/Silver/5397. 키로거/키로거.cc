#include <iostream>
#include <stack>

using namespace std;

void truePW(string s) {
	stack<char> stleft, stright;

	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '-') {
			if (!stleft.empty()) {
				stleft.pop();
			}
		}
		else if (s[i] == '<') {
			if (!stleft.empty()) {
				stright.push(stleft.top());
				stleft.pop();
			}
		}
		else if (s[i] == '>') {
			if (!stright.empty()) {
				stleft.push(stright.top());
				stright.pop();
			}
		}
		else {
			stleft.push(s[i]);
		}
	}
	while (!stleft.empty()) {
		stright.push(stleft.top());
		stleft.pop();
	}
	while (!stright.empty()) {
		cout << stright.top();
		stright.pop();
	}
	cout << '\n';
	return;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int n;
	string s;
	cin >> n;

	while (n--) {
		cin >> s;
		truePW(s);
	}
}