#include <iostream>
#include <vector>

using namespace std;
const int INF = 1e7;

void floydWarshall(int n, vector<vector<int>> &graph) {
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int cost = graph[i][k] + graph[k][j];
				graph[i][j] = min(graph[i][j], cost);
			}
		}
	}
}

int main() {
	int n, m, a, b, c;

	cin >> n >> m;
	vector<vector<int>> graph(n + 1, vector<int>(n + 1, INF));
	for (int i = 1; i <= n; i++) {
		graph[i][i] = 0;
	}
	while (m--) {
		cin >> a >> b >> c;
		graph[a][b] = min(graph[a][b], c);
	}

	floydWarshall(n, graph);

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cout << (graph[i][j] == INF ? 0 : graph[i][j]) << ' '; //꼭 괄호로 묶기
		}
		cout << '\n';
	}
	return 0;
}