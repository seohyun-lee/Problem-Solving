#include <iostream>
#include <vector>
#include <queue>

using namespace std;
typedef pair<int, int> ci;
const int INF = 2e9;

vector<int> dijkstra(int start, int v, vector<vector<ci>>& graph) {
	vector<int> dist(v + 1, INF); //각 정점까지의 최단 경로 저장
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
	int v, e, k, a, b, w;
	cin >> v >> e >> k;
	vector<vector<ci>> graph(v + 1, vector<ci>(0));
	while (e--) {
		cin >> a >> b >> w;
		graph[a].push_back({ b, w });
	}
	vector<int> dist = dijkstra(k, v, graph);
	for (int i = 1; i <= v; i++) {
		if (dist[i] == INF) {
			cout << "INF";
		} else {
			cout << dist[i];
		}
		cout << '\n';
	}
	return 0;
}