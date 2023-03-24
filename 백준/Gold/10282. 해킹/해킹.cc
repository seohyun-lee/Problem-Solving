#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
const int INF = 987654321;
typedef pair<int, int> ci;

vector<int> dijkstra(int start, int n, vector<vector<ci>> graph) {
	vector<int> dist(n + 1, INF);
	priority_queue<ci, vector<ci>, greater<>> pq;

	dist[start] = 0;
	pq.push({ 0, start });
	while (!pq.empty()) {
		int weight = pq.top().first;
		int node = pq.top().second;
		pq.pop();

		if (weight > dist[node]) {
			continue;
		}

		for (int i = 0; i < graph[node].size(); i++) {
			int next_node = graph[node][i].first;
			int next_weight = weight + graph[node][i].second;
			if (next_weight < dist[next_node]) {
				dist[next_node] = next_weight;
				pq.push({ next_weight, next_node });
			}
		}
	}
	return dist;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int t;
	cin >> t;
	while (t--) {
		vector<vector<ci>> graph(10001, vector<ci>(0));
		int n, d, c;
		cin >> n >> d >> c;
		for (int i = 0; i < d; i++) {
			int a, b, s;
			cin >> a >> b >> s;
			graph[b].push_back({ a, s });
		}
		vector<int> dist = dijkstra(c, n, graph);

		int cnt = 0;
		int sec = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] != INF) {
				cnt++;
				sec = max(sec, dist[i]);
			}
		}
		cout << cnt << ' ' << sec << '\n';
	}
	return 0;
}