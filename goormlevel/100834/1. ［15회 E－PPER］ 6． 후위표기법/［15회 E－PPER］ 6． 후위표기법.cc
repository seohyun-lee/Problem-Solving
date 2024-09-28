#include <iostream>
#include <string>
#include <stack>
#include <vector>

using namespace std;

int doOperation(int n1, int n2, char op)
{
	if(op=='+') return n1+n2;
	else if (op == '-') return n1-n2;
	else if (op == '*') return n1*n2;
	else if (op == '/') return n1/n2;
	else return 0;
}

int calcPost(vector<char> v)
{
	int n = v.size();
	stack<int> stack;
	for (int i=0; i<n; i++) {
		char cur = v[i];
		if (cur >= '0'&& cur <= '9') {
			stack.push(cur - '0');
		} else {
			int n2 = stack.top();
			stack.pop();
			int n1 = stack.top();
			stack.pop();
			int result = doOperation(n1, n2, cur);
			stack.push(result);
		}
	}
	return stack.top();
}
int main() {
	vector<char> v;
	int n;
	cin >> n;
	for (int i=0; i<n; i++) {
		char x;
		cin >> x;
		v.push_back(x);
	}
	cout << calcPost(v);
	return 0;
}