#include <iostream>
#include <queue>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	int n;
	cin >> n;
	priority_queue<int, vector<int>, greater<int>> pq;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		pq.push(x);
	}
	for (int i = n; i < n * n; i++) {
		int x;
		cin >> x;
		if (x > pq.top()) {
			pq.pop();
			pq.push(x);
		}
	}
	cout << pq.top() << '\n';
	return 0;
}