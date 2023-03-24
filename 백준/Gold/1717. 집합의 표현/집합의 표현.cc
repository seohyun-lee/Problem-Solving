#include <iostream>
#include <vector>

using namespace std;
vector<int> parent;

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
	if (parent[xp] < parent[yp]) {
		parent[xp] += parent[yp];
		parent[yp] = xp;
	}
	else {
		parent[yp] += parent[xp];
		parent[xp] = yp;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n, m, cmd, a, b;

	cin >> n >> m;
	parent.assign(n + 1, -1);
	while (m--) {
		cin >> cmd >> a >> b;
		if (!cmd) {
			unionInput(a, b);
		}
		else {
			if (findParent(a) == findParent(b)) {
				cout << "YES\n";
			}
			else {
				cout << "NO\n";
			}
		}
	}
	return 0;
}