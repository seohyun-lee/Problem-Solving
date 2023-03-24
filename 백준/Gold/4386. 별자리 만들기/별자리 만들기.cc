#include <iostream>
#include <cmath>
#include <queue>

using namespace std;

typedef pair<double, int> ci;
const int INF = 1e5;

double prim(int n, int start, vector<vector<ci>>& graph) {
    double sum = 0;
    priority_queue<ci, vector<ci>, greater<>> pq;
    vector<double> dist(n, INF);
    vector<bool> visited(n, false);

    dist[start] = 0;
    pq.push({ 0, start });

    while (!pq.empty()) {
        auto[curr_w, curr] = pq.top();
        pq.pop();

        if (visited[curr]) {
            continue;
        }
        visited[curr] = true;
        sum += curr_w;

        for (auto [next_w, next] : graph[curr]) {
            if (!visited[next] && next_w < dist[next]) {
                pq.push({ next_w, next });
                dist[next] = next_w;
            }
        }
    }

    return sum;
}

int main() {
    int n;
    double x, y;
    cin >> n;

    vector<pair<double, double>> star;
    vector<vector<ci>> graph(n, vector<ci>(0));
    for(int i = 0; i<n; i++){
        cin >> x >> y;
        for (int j = 0; j < i; j++) {
            double dx = x - star[j].first;
            double dy = y - star[j].second;
            double dist = sqrt(dx * dx + dy * dy);

            graph[i].push_back({ dist, j });
            graph[j].push_back({ dist, i });
        }
        star.push_back({ x, y });
    }
    cout << fixed;
    cout.precision(2);
    cout << prim(n, 0, graph);
    return 0;
}