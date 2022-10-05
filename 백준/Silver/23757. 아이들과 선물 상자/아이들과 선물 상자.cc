#include <iostream>
#include <queue>

using namespace std;

int main() {
	int n, m;
	priority_queue<int> gift;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		gift.push(a);
	}
	for (int j = 0; j < m; j++) {
		int a;
		cin >> a;
		if (a > gift.top()) {
			cout << 0;
			return 0;
		}
		else {
			gift.push(gift.top() - a);
			gift.pop();
		}
	}
	cout << 1;
}