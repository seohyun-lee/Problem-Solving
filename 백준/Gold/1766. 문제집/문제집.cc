#include <iostream>
#include <vector>
#include <queue>
#include <functional>
using namespace std;

const int MAX = 32001;


int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;

    vector<int> graph[MAX];
    int inDegree[MAX] = { 0, };
    priority_queue<int, vector<int>, greater<int>> pq;

    while (m--) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        inDegree[b]++;
    }

    for (int i = 1; i <= n; i++) {
        if (inDegree[i] == 0) {
            pq.push(i);
        }
    }

    while (!pq.empty()) {
        int node = pq.top();
        pq.pop();
        cout << node << " ";

        for (int i = 0; i < graph[node].size(); i++) {
            int next = graph[node][i];
            inDegree[next]--;
            if (inDegree[next] == 0) {
                pq.push(next);
            }
        }
    }

    return 0;
}