#include <iostream>
#include <vector>
#include <stack>

using namespace std;
const int SIZE = 1e4;
vector<int> stack_vec(SIZE); //와이?
int top_pointer = -1;

int main() {
	int n, x;
	string cmd;
	stack<int> st;

	cin >> n;
	while (n--) {
		cin >> cmd;
		if (cmd == "push") {
			cin >> x;
			st.push(x);
			continue;
		}
		if (cmd == "pop") {
			if (st.empty()) {
				cout << "-1\n";
			}
			else {
				cout << st.top() << '\n';
				st.pop();
			}
			continue;
		}
		if (cmd == "size") {
			cout << st.size() << '\n';
			continue;
		}
		if (cmd == "empty") {
			cout << st.empty() << '\n';
			continue;
		}
		if (cmd == "top") {
			if (st.empty()) {
				cout << "-1\n";
			}
			else {
				cout << st.top() << '\n';
			}
		}
	}
}