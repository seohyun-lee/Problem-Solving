#include <iostream>
#include <queue>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	int n, h, t, i;
	cin >> n >> h >> t;
	priority_queue<int> pq;
	for (i = 0; i < n; i++) {
		int x;
		cin >> x;
		pq.push(x);
	}
	for (i = 0; i < t;) {
		if (pq.top() < h || pq.top() == 1) {
			break;
		}
		int a = pq.top();
		pq.pop();
		pq.push(a/2);
		i++;
	}
	if (h > pq.top()) {
		cout << "YES" << '\n' << i;
	}
	else {
		cout << "NO" << '\n' << pq.top();
	}
	return 0;
}