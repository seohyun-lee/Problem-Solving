#include <iostream>
#include <vector>
#include <string>

using namespace std;
vector<int> parent;

int friendshipCost(int n) {
	int sum = 0;
	for (int i = 1; i <= n; i++) {
		if (parent[i] < 0) {
			sum -= parent[i];
		}
	}
	return sum;
}

int findParent(int node) {
	if (parent[node] < 0) {
		return node;
	}
	return parent[node] = findParent(parent[node]);
}

void unionInput(int x, int y) {
	int xp = findParent(x);
	int yp = findParent(y);

	if (xp == yp) {
		return;
	}
	if (parent[xp] > parent[yp]) {
		parent[yp] = xp;
	}
	else {
		parent[xp] = yp;
	}
}

int main() {
	int n, m, k, v, w, cost;

	cin >> n >> m >> k;
	parent.assign(n + 1, 0);
	for (int i = 1; i <= n; i++) {
		cin >> cost;
		parent[i] = -cost;
	}

	while (m--) {
		cin >> v >> w;
		unionInput(v, w);
	}
	int ans = friendshipCost(n);

	cout << (ans <= k ? to_string(ans) : "Oh no"); //자료형 맞춰야 한다

	return 0;
}