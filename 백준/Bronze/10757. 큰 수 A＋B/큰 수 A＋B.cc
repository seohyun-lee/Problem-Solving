#include <iostream>
#include <string>
using namespace std;

int sum[10001] = {};

int calculate(string x, string y) {
	int cnt;
	for (int i = 0; i < y.size(); i++) {
		int xnum = 0;
		int ynum = (int)y[y.size() - i - 1]-'0';
		if(i<x.size())
			xnum= (int)x[x.size() - i - 1]-'0';
		sum[i] = sum[i] + xnum + ynum;
		if (sum[i] >= 10) {
			sum[i] -= 10;
			sum[i + 1]++;
		}
	}
	if (sum[y.size()] != 0)
		cnt = y.size() + 1;
	else
		cnt = y.size();
	return cnt;
}

int main() {
	string a, b;
	int cnt;
	cin >> a >> b;
	if (a.size() <= b.size()) {
		cnt = calculate(a, b);
	}
	else {
		cnt = calculate(b, a);
	}
	for (int i = cnt-1; i >=0; i--) {
		cout << sum[i];
	}
	return 0;
}