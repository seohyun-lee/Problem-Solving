#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> graph;
vector<bool> visited;
bool is_tree;

void printResult(int tc, int cnt) {
	cout << "Case " << tc << ": ";

	switch (cnt) {
		case 0:
			cout << "No trees.\n";
			break;
		case 1:
			cout << "There is one tree.\n";
			break;
		default:
			cout << "A forest of " << cnt << " trees.\n";
	}
	return;
}

void dfs(int curr, int prev) {
	if (visited[curr]) {
		is_tree = false;
		return;
	}
	visited[curr] = true;

	for (int next : graph[curr]) {
		if (next == prev) {
			continue;
		}
		dfs(next, curr);
	}
	return;
}

int main() {
	int n, m, a, b, tc = 0;

	while (cin >> n >> m) {
		if (n == 0 && m == 0) {
			break;
		}

		tc++;
		graph.assign(n + 1, vector<int>(0));
		visited.assign(n + 1, false);

		while (m--) {
			cin >> a >> b;
			graph[a].push_back(b);
			graph[b].push_back(a);
		}

		int tree_cnt = 0;

		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				continue;
			}
			is_tree = true;
			dfs(i, 0);
			if (is_tree) {
				tree_cnt++;
			}
		}

		printResult(tc, tree_cnt);
	}
	return 0;
}