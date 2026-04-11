#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n, m;
    cin>>n>>m;
    vector<vector<int>> graph(n+1);
    vector<int> indegree(n+1, 0);
    
    while(m--){
        int a, b;
        cin>>a>>b;
        graph[a].push_back(b); // a->b
        indegree[b]++; //b의 진입차수+1
    }
    
    queue<int> q; // indegree[i] == 0, 출력해도 되면 q에 넣음
    for (int i = 1; i <= n; i++) {
        if (indegree[i] == 0) q.push(i);
    }

    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        cout << cur << ' ';
        for (int nxt : graph[cur]) {
            indegree[nxt]--; // 자식들의 진입차수를 줄임
            if (indegree[nxt] == 0) q.push(nxt);
        }
    }
    return 0;
}